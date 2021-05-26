// DOCUMENTATION https://tarekraafat.github.io/autoComplete.js/#/
const autoCompleteJS = new autoComplete({
	data: {
		src: async function() {
			// Loading placeholder text
			document.querySelector('#autoComplete').setAttribute('placeholder', 'Loading...');
			// Fetch External Data Source

			const source = await fetch('/usersAutocomplete');
			const data = await source.json();

			// Post Loading placeholder text
			document.querySelector('#autoComplete').setAttribute('placeholder', autoCompleteJS.placeHolder);
			// Returns Fetched data
			return data;
		},
		key: [ 'userEmail', 'userCpr' ]
	},
	trigger: {
		event: [ 'input', 'focus' ]
	},
	placeHolder: 'Search for Email or CPR...',
	searchEngine: 'strict',
	resultsList: {
		noResults: (list, query) => {
			// No Results List Message
			const message = document.createElement('div');
			message.setAttribute('class', 'no_result');
			message.innerHTML = `<span style="display: flex; align-items: center; font-weight: 100; color: rgba(0,0,0,.2);">Found No Results for "${query}"</span>`;
			list.appendChild(message);
		}
	},
	resultItem: {
		content: (data, element) => {
			// Modify Results Item Style
			element.style = 'display: flex; justify-content: space-between;';
			// Modify Results Item Content
			element.innerHTML = `
        <span style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
            ${data.match}
        </span>
        <span style="display: flex; align-items: center; font-size: 13px; font-weight: 100; text-transform: uppercase; color: rgba(0,0,0,.2);">
            ${data.key}
        </span>`;
		},
		highlight: {
			render: true
		}
	},
	onSelection: (feedback) => {
		document.querySelector('#autoComplete').blur();
		// Prepare User's Selected Value
		const selection = feedback.selection.value[feedback.selection.key];
		post('/findUser', selection, 'userDetails');
	}
});

function post(path, value, name, method = 'post') {
	// The rest of this code assumes you are not using a library.
	// It can be made less verbose if you use one.
	const form = document.createElement('form');
	form.method = method;
	form.action = path;

	const hiddenField = document.createElement('input');
	hiddenField.type = 'hidden';
	hiddenField.name = name;
	hiddenField.value = value;

	form.appendChild(hiddenField);

	document.body.appendChild(form);
	form.submit();
}
