const title = document.querySelector('h1')
const destination = document.querySelector('.api-data');

const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && xhr.responseText === "") {
		alert("You did bad and you should feel bad.")
	}
	if (this.readyState == 4 && this.status == 200) {
		const res = JSON.parse(xhr.responseText);
		title.innerText = `List of Courses`
		let html = ''
		if (res.length) {
			res.forEach(item => {
				html += `
					<li>
						<a href="/courses/${item.id}">${item.name}</a>, Instructor: ${item.instructor.name}
					</li>
				`
			})
		} else {
			html = `
				<li>
					<h2>${res.name}</h2>
					<h3>${res.instructor.name}</h3>
					<p>${res.description}</p>
				</li>
			`
		}
		destination.innerHTML = html
	}
}

document.querySelector('button').addEventListener('click', executeRequest)

function executeRequest() {
	xhr.open("GET", `/api/courses/${document.querySelector('input').value}`, true)
	xhr.send()
}