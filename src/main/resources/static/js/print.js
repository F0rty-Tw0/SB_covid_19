function printDiv() {
	var divContents = document.getElementById('vacPass').innerHTML;
	var a = window.open('', '', 'height=600, width=600');
	a.document.write('<html><head>');
	a.document.write('<link href="/css/styles.css" rel="stylesheet">');
	a.document.write('<link rel="stylesheet" href="/webjars/bootstrap/5.0.0-beta2/css/bootstrap.min.css" />');
	a.document.write('</head><body >');
	a.document.write(divContents);
	a.document.write('</body></html>');
	a.document.close();
	a.print();
}
