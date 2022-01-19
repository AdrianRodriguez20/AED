const http = require('http');
const url = require('url');
const puerto = 8000;
http.createServer((req, res) => {
    res.setHeader("Content-Type", "application/json; charset=utf-8");
    res.write(`Servidor funcionando en ${puerto} `);
    const query0bject = url.parse(req.url, true).query;
    console.log(query0bject);
    let texto = "";
    Object.entries(query0bject)
        .forEach((par) => texto += (par[0] + ": " + par[1]) + "\n");
    res.write(` se recibió como parámetro: ${texto}`);
    res.end();
}).listen(puerto);