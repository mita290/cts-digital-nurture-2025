//task - 1
console.log("Welcome to the Community Portal");
window.onload = function () {
    alert("Page loaded successfully!");
    task4();
    displayValidEvents();
    task5And6();
    fetchEvents();
};

// tasks 2 - 4
const eventList = [
      {id : 1, name: "Art Expo", date: "2025-06-15", seats: 25, category: "artFair"},
];
let filteredEvents = [...eventList];

function displayValidEvents() {
    if (eventList.length !== 0) {
        const today = new Date();
        console.log("Valid Upcoming Events");
        eventList.forEach(e => {
            const edate = new Date(e.date);
            if (edate > today && e.seats > 0) {
                console.log(`${e.name} - ${e.date} - Available Seats: ${e.seats}`);
            } else {
                console.log(`${e.name} is in the past or full`);
            }
        });
    }
};

function registerUserForm() {
    try {
        const seatsInput = document.getElementById("seats");
        let availableSeats = parseInt(seatsInput.value);

        if (availableSeats > 0) {
            availableSeats--;
            seatsInput.value = availableSeats;
            console.log(`Seats left: ${availableSeats}`);
        } else {
            alert("No seats available");
            console.log("Registration failed. No seats left.");
        }
    } catch(err) {
        console.error(err);
    }
};

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form[onsubmit]");
    form.addEventListener("submit", () => {
        registerUserForm();
    });
});

function addEvent(id, name, date, seats, category) {
    eventList.push({ id, name, date, seats, category });
    filteredEvents = eventList;
    renderEvents(filteredEvents);
    console.log("Event List Updated");
};

function registerUser(userName, eventName) {
    const event = eventList.find(e => e.name === eventName);
    if (event && event.seats > 0) {
        event.seats--;
        console.log(`${userName} registered for ${eventName}`);
    } else {
        console.log("Event full or not found");
    }
};

function createCategoryCounter() {
    const counts = {};
    return function (category) {
        counts[category] = (counts[category] || 0) + 1;
        console.log(`Registrations for ${category}: ${counts[category]}`);
    };
};
const countRegistration = createCategoryCounter();


function task4() {
    console.log("Outputs for task4:\n")
    const obj = {
        id: 8,
        name: "Food Drive",
        date: "2025-06-09",
        seats: 2,
        category: "Charity"
    }
    addEvent(obj.id, obj.name, obj.date, obj.seats, obj.category);
    registerUser("ABC", "Art Expo");
    console.log("Filtered by Art Fair Category:");
    console.log(JSON.stringify(eventList.filter(e => e.category === "artFair")));
    countRegistration("foodFest");
    countRegistration("music");
    countRegistration("artFair");
    countRegistration("Charity");
};

// tasks 5 - 6
class Event {
    constructor(name, date, seats, category) {
        this.name = name;
        this.date = date;
        this.seats = seats;
        this.category = category;
    }

    checkAvailability() {
        const today = new Date();
        const eventDate = new Date(this.date);
        return this.seats > 0 && eventDate > today;
    }

};

const communityEvents = [
    new Event("Coding Bootcamp", "2025-07-10", 20, "Education"),
    new Event("Jazz Night", "2024-12-01", 0, "Music"),
    new Event("Baking Workshop", "2025-08-05", 15, "Food")
];
function task5And6() {
    console.log("Outputs for tasks 5 & 6:\n")
    communityEvents.forEach(e => {
        console.log(`Event: ${e.name}`);
        Object.entries(e).forEach(([key, value]) => {
            console.log(` ${key}: ${value}`);
        });
    });

    communityEvents.push(new Event("Painting Class", "2025-09-12", 10, "Art"));
    const musicEvents = communityEvents.filter(e => e.category === "Music");
    const displayCards = communityEvents.map(e => {
        return `${e.category}: ${e.name} on ${e.date}`;
    });
    console.log("Formatted Display Cards:");
    displayCards.forEach(card => console.log(card));
    console.log("Filtered Music Events:");
    musicEvents.forEach(card => console.log(card));
};

//task 7
function filterEventsByCategory(category = "All", callback) {
    console.log("Task 7: DOM Manipulation - Filter Events");
    let filtered = [];
    if (category === "All") {
        filtered = [...eventList];
    } else {
        filtered = eventList.filter(ev => ev.category === category);
    }
    filteredEvents = filtered;
    if (callback && typeof callback === 'function') {
        callback(filtered);
    } else {
        renderEvents(filtered);
    }
};

function renderEvents(eventList) {
    const container = document.getElementById("eventCards");
    container.innerHTML = "";

    eventList.map(ev => {
        const card = document.createElement("div");
        card.className = "event-card";
        const today = new Date();
        const edate = new Date(ev.date);
        card.innerHTML = `
            <h4>${ev.name}</h4>
            <p>Date: ${ev.date}</p>
            <p>Seats left: ${ev.seats}</p>
            <p>Category: ${ev.category}</p>
            <p>Status: ${edate < today ? "Past" : "Upcoming"}</p>
            <button onclick="registerForEvent(${ev.id})" ${ev.seats === 0 || edate < today ? "disabled" : ""}>Register</button>
        `;

        container.appendChild(card);
    });
};

function registerForEvent(eventId) {
    console.log("Task 7: DOM Manipulation - Registered For Event");
    const evIndex = eventList.findIndex(ev => ev.id === eventId);
    if (evIndex === -1) return alert("Event not found");

    if (eventList[evIndex].seats <= 0) {
        alert("No seats available for this event.");
        return;
    }
    registerUser("", eventList[evIndex].name);
    renderEvents(filteredEvents);

    alert(`Registered successfully for "${eventList[evIndex].name}"!`);
};

//task - 8
document.getElementById("searchName").addEventListener("keydown", function (e) {
    console.log("Task 8: Search Bar");
    if (e.key === "Enter") {
        e.preventDefault();
        const searchTerm = e.target.value.toLowerCase();
        const searched = eventList.filter(ev => ev.name.toLowerCase().includes(searchTerm));
        filteredEvents = searched;
        renderEvents(searched);
    }
});

//task - 9
const mockApiUrl = "./events.json";
async function fetchEvents() {
    console.log("Task 9 - Fetch API used");
    const container = document.getElementById("eventCards");
    container.innerHTML = "<p>Loading events...</p>";
    
    try {
        const response = await fetch("./events.json");
        if (!response.ok) throw new Error("Failed to fetch events.json");
        
        const data = await response.json();

        eventList.length = 0;

        data.forEach(item => {
            const { id, name, date, seats, category } = item;
            addEvent(id, name, date, seats, category);
        });

        renderEvents(eventList);
    } catch (err) {
        container.innerHTML = `<p style="color:red">Error loading events: ${err.message}</p>`;
    }
};

//task - 10
const registrationForm = document.getElementById("registrationForm");
registrationForm.addEventListener("submit", handleRegistrationFormSubmit);

function handleRegistrationFormSubmit(event) {
    console.log("Task 10 - Registration Form")
    event.preventDefault();
    console.log("Form submission triggered");

    const form = event.target;
    const { name, email, eventType, date } = form.elements;

    console.log("Form values:", { name: name.value, email: email.value, eventType: eventType.value, date: date.value });

    let errorMessages = [];
    if (!name.value.trim()) errorMessages.push("Name is required.");
    if (!email.value.trim() || !email.value.includes('@')) errorMessages.push("Valid email required.");
    if (!eventType.value) errorMessages.push("Event selection required.");
    if (!date.value) errorMessages.push("Date is required.");

    const confirmation = document.getElementById("confirmation");

    if (errorMessages.length > 0) {
        confirmation.style.color = 'red';
        confirmation.textContent = errorMessages.join(' ');
        console.warn("Form validation errors:", errorMessages);
        return;
    }

    const data = {
        name: name.value,
        email: email.value,
        event: eventType.value,
        date: date.value
    };

    postRegistrationData(data);
};

//tasks 11 & 12
async function postRegistrationData(data) {
    console.log("Tasks 11 & 12 - Starting registration POST with data:", data);
    try {
        const confirmation = document.getElementById("confirmation");
        confirmation.style.color = 'blue';
        confirmation.textContent = "Submitting your registration...";

        await new Promise(resolve => setTimeout(resolve, 1500)); 
        console.log("Sending POST request to server...");

        const response = await fetch(mockApiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        console.log("Response status:", response.status);

        if (!response.ok) throw new Error(`Server error: ${response.status}`);

        const result = await response.json();
        console.log("Server response JSON:", result);

        confirmation.style.color = 'green';
        confirmation.textContent = `Registration successful! Reference ID: ${result.id}`;
    } catch (error) {
        console.error("Registration error:", error);
        const confirmation = document.getElementById("confirmation");
        confirmation.style.color = 'red';
        confirmation.textContent = `Registration failed: ${error.message}`;
    }
};

// task - 13
function initApp() {
    console.log("Task 13");
    renderEvents(eventList);

    const filterSelect = document.getElementById("filterCategory");
    filterSelect.addEventListener("change", e => {
        filterEventsByCategory(e.target.value);
    });

    const pref = localStorage.getItem("eventPref");
    if (pref) {
        document.getElementById("eventType").value = pref;
    }
};