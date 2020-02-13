const MAIN_URL = 'https://frozen-plateau-92166.herokuapp.com/';
const WEATHER_API_URL = MAIN_URL + 'weather/';
const CURRENCY_API_URL = MAIN_URL + 'currency/';

//weather api

const searchBtn = document.getElementById('weatherSearchButton');

searchBtn.addEventListener('click', (event) => {
    event.preventDefault();
    const cityName = document.getElementById('cityInput').value;
    const weatherInfoSpan = document.getElementById('weatherInfo');
    const url = WEATHER_API_URL + cityName;
    fetch(url)
        .then(processOkResponse)
        .then(response => {
            addWeatherInfoToWeb(response, weatherInfoSpan);

        })
        .catch(console.warn);
});

function addWeatherInfoToWeb(res, weatherInfoSpan) {
    const div = document.createElement('div');

    while (weatherInfoSpan.firstChild) {
        weatherInfoSpan.removeChild(weatherInfoSpan.firstChild);
    }

    for (let key in res) {
        if (key === 'iconURL') continue;
        const p = document.createElement('p');
        p.innerHTML += key + ' : ' + res[key];
        div.appendChild(p);
    }

    weatherInfoSpan.appendChild(createImg(res.iconURL));
    weatherInfoSpan.appendChild(div);

}

function createImg(iconURL) {
    const img = document.createElement("img");
    img.src = iconURL;

    return img;
}

//currency api

const sendAnswerBtn = document.getElementById('sendAnswerButton');
startCurrencyGame();

function startCurrencyGame() {
    fetch(CURRENCY_API_URL)
        .then(response => {
            return response.text();
        })
        .then(text => addQuestionToPage(text))
        .catch(console.warn);
}


function addQuestionToPage(text) {
    const questionHeading = document.getElementById('questionHeading');
    questionHeading.innerText = text;
}

sendAnswerBtn.addEventListener('click', (event) => {
    event.preventDefault();
    const answer = getAnswer();
    fetch(CURRENCY_API_URL + answer)
        .then(response => {
            return response.text()
        })
        .then(text => addReplyToPage(text))
        .catch(console.warn);
});

function getAnswer() {
    let answer = document.getElementById('currencyAnswerInput').value;
    answer = answer.replace(/,/g, '.')
    return answer;
}

function addReplyToPage(text) {
    const replyParagraph = document.getElementById('replyParagraph');
    replyParagraph.innerText = text;
}

// others

function objectToArray(obj) {
    const tab = [];
    printValues(obj, tab);
    return tab;
}

function printValues(obj, tab) {

    for (var key in obj) {
        if (typeof obj[key] === "object") {
            printValues(obj[key], tab);
        } else {
            tab.push(obj[key]);
            console.log(obj[key]);
        }
    }
}

function processOkResponse(response = {}) {
    if (response.ok) {
        return response.json();
    }
    throw new Error(`Status not 200 (${response.status})`);
}
