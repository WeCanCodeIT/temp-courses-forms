//{"id":2,"name":"Javascript","description":"Javascript Description",
//"instructor":{"id":3,"name":"Donny","coursesUrls":["/courses/2"]}}

const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.response);

		if(res.length) {
			res.forEach(function(course) {
				appendOneElementToBody(course)
			})
		} else {
			appendOneElementToBody(res)
		}
		
		function appendOneElementToBody(res) {
			const body = document.body

			const courseContainer = document.createElement('div')
			courseContainer.classList.add('courseContainer')

			appendElement(courseContainer, createElement('h2', res.name))
			appendElement(courseContainer, createElement('p', res.description))
			appendElement(courseContainer, createElement('h3', res.instructor.name))
			res.instructor.coursesUrls.forEach(function(coursesUrl) {
				const courseLink = createElement('a', coursesUrl)
				courseLink.setAttribute('href', coursesUrl)
				appendElement(courseContainer, courseLink)

			})

			appendElement(body, courseContainer)
		}

		function createElement(elem, textValue) {
			const newElem = document.createElement(elem)
			newElem.innerText = textValue
			return newElem
		}

		function appendElement(parent, child) {
			parent.appendChild(child)
		}

		function showAllPropsInObject(object) {
			for (prop in res) {
				console.log(`${prop}: ${res[prop]}`)
				// prop + ': ' + res[prop]
			}
		}

		console.log(res)
	}
}

xhr.open('GET', 'http://localhost:8080/courses', true)
xhr.send()