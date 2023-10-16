const calculateButton = document.getElementById('calculate');
const budgetInput = document.getElementById('budget');
const resultList = document.getElementById('result-list');
const resultContainer = document.querySelector('.result_container');
const totalLength = document.getElementById('total-length');
const loader = document.getElementById('loader'); 

calculateButton.addEventListener('click', () => {
    resultList.innerHTML = null;
    const budget = parseFloat(budgetInput.value);
    console.log("budget =" + budget);

    if (isNaN(budget) || budget < 230) {
        alert("Insufficient budget");
        resultList.innerHTML = 'Please enter a valid budget.';
        totalLength.innerHTML = '';
    } else {
        const url = 'https://backendservice-6vll.onrender.com/combination?budget=' + budget;

        
        loader.style.display = 'block';

        fetchTimeout = setTimeout(() => {
            loader.style.display = 'none'; 
            alert("Fetching data is taking too long. Please try again.");
        }, 8000); 

        fetch(url)
            .then(response => response.json())
            .then(data => {
                clearTimeout(fetchTimeout); 
                data.forEach(item => {
                    console.log(item);
                    resultList.innerHTML += `<p>${item}</p>`;
                });
                totalLength.innerHTML = `Total combinations: ${data.length}`;
                loader.style.display = 'none'; 
                
            })
            .catch(error => {
                clearTimeout(fetchTimeout); 
                loader.style.display = 'none';
                console.error('An error occurred:', error);
            });

            resultContainer.style.display = 'block';
    }
});
