const onReady = (callback) => {
	var intervalId = window.setInterval(function() {
		if (document.getElementsByTagName('body')[0] !== undefined) {
			window.clearInterval(intervalId);
			callback.call(this);
		}
	}, 250);
};

const setVisible = (selector, visible) => {
	document.querySelector(selector).style.display =
		visible ? 'block' :
		'none';
};

const pageTransition = () => {
	setVisible('#loading', true);
};

onReady(() => {
	setVisible('.wrapper', true);
	setVisible('#loading', false);
});
