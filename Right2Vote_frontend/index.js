
const calculateButton = document.getElementById('calculate');
const budgetInput = document.getElementById('budget');
const resultList = document.getElementById('result-list');
const resultContainer = document.querySelector('.result_container');
const totalLength = document.getElementById('total-length');

calculateButton.addEventListener('click', () => {
    resultList.innerHTML=null;
    const budget = parseFloat(budgetInput.value);
    console.log("budget ="+budget);

    if (isNaN(budget)) {
        resultList.innerHTML = 'Please enter a valid budget.';
        totalLength.innerHTML = '';
    } else {
        const apiUrl = 'https://backendservice-6vll.onrender.com/combination?budget=' + budget; 

        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                //console.log(data);
                data.forEach(item => {
                    console.log(item)
                    resultList.innerHTML += `<p>${item}</p>`;
                });
                totalLength.innerHTML = `Total items: ${data.length}`;
                resultContainer.style.display = 'block';
            });
    }
});


