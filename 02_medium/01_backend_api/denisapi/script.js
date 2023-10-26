
const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.json());

app.post('/api/sort', (req, res) => {
  const array = req.body;
  const sortedArray = array.sort();
  res.json({sortedArray});
});


app.listen(3000, () => {
  console.log(`Server running on port 3000`);
});
