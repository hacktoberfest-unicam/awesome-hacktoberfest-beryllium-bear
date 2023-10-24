const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

// Parse JSON requests
app.use(bodyParser.json());

// Sort and return an array
app.post('/sort', (req, res) => {
    try {
        const inputArray = req.body.array;

        if (!Array.isArray(inputArray)) {
            return res.status(400).json({error: 'Input must be an array'});
        }

        const sortedArray = inputArray.sort();

        res.json({sortedArray});
    } catch (error) {
        res.status(500).json({error: 'Internal server error'});
    }
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
