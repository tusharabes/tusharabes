const http = require("http");
const fs= require("fs");
const server = http.createServer((req,res) =>{
	if(req.url=="/gst")
	{
		const output=fs.readFile("db.json","utf-8",(err,data) =>
			{
				res.end(data);
			}
		);
	}
});

server.listen(8080,"192.168.43.164",() =>{
	console.log("listening to port no 8080");
});