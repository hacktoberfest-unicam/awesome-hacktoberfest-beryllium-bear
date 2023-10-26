const axios = require('axios');

const inputArray = [3, 1, 2, 5, 4];

axios.post('http://localhost:3000/sort', {array: inputArray})
    .then(response => {
        console.log('Sorted Array:', response.data.sortedArray);
    })
    .catch(error => {
        console.error('Error:', error.response.data.error);
    });
