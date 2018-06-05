var express = require('express');
var app = express();

app.use(express.static('public'));

app.get('/', function(req, res){
    res.sendfile('mysite.html');
});

app.listen(3000);