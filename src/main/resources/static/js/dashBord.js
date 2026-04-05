document.getElementById("stateDropdown").addEventListener("change", function () {

    let stateId = this.value;
    let cityDropdown = document.getElementById("cityDropdown");

    cityDropdown.innerHTML = '<option>Select City</option>';

    if (!stateId) return;

    fetch("/getCitiesByState?stateId=" + stateId)
        .then(res => res.json())
        .then(data => {

            console.log(data); // 🔥 check in console

            data.forEach(city => {
                let option = document.createElement("option");
                option.value = city.cityId;
                option.text = city.cityName;
                cityDropdown.appendChild(option);
            });

        });
});