// DOCUMENTATION https://tarekraafat.github.io/autoComplete.js/#/
const autoCompleteJS = new autoComplete({
	data: {
		src: async function() {
			// Loading placeholder text
			document.querySelector('#autoComplete').setAttribute('placeholder', 'Loading...');
			// Fetch External Data Source

			const source = await fetch('/usersAutocomplete');
			const data = await source.json();
			console.log(data);

			// Post Loading placeholder text
			document.querySelector('#autoComplete').setAttribute('placeholder', autoCompleteJS.placeHolder);
			// Returns Fetched data
			return data;
		},
		key: [ 'food', 'cities', 'animals' ],		
	},
	trigger: {
		event: [ 'input', 'focus' ]
	},
	placeHolder: 'Search for Food & Drinks!',
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
		// Render selected choice to selection div
		document.querySelector('.selection').innerHTML = selection;
		// Replace Input value with the selected value
		document.querySelector('#autoComplete').value = selection;
		// Console log autoComplete data feedback
		console.log(feedback);
	}
});
