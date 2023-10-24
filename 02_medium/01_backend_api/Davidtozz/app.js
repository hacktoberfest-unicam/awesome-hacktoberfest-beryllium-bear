const express = require('express');
const bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.json());

app.get('/', (req, res) => {
  res.json({ message: 'Welcome to the Express.js API' });
});

app.post('/api/sort', (req, res) => {
    const { array } = req.body;
  
    if (!array || !Array.isArray(array)) {
      return res.status(400).json({ error: 'invalid input' });
    }
    array.sort((a, b) => a - b);    
    res.json({ sortedArray: array });
  });

const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
