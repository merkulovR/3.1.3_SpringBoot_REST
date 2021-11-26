let url = "http://localhost:8080/admin/users"
    function sendGet(url) {
    return fetch(url, {
        method:"GET",
        headers: {
            "Content-type":"application/json"
        }
    }).then(response => response.json()
    )
}

function sendPut(url) {
    return fetch(url, {
        method:"PUT",
        headers: {
            "Content-type":"application/json"
        }
    }).then(response => response.json()
    )
}

function sendDelete(url) {
    return fetch(url, {
        method: "DELETE",
        headers: {
            "Content-type": "application/json"
        }
    }).then(response => response.json()
    )
}

function sendPost(url) {
    return fetch(url, {
        method:"POST",
        headers: {
            "Content-type":"application/json"
        }
    }).then(response => response.json()
    )
}

function showUsersTable() {
    fetch("http://localhost:8080/admin/users").then(
        resp => {
            resp.json().then(
                usersData => {
                    console.log(usersData);
                    if (usersData.length > 0) {
                        let temp = "";
                        usersData.forEach(user => {
                            // temp += "<tr>";
                            // temp += "<td>" + user.id + "</td>";
                            // temp += "<td>" + user.name + "</td>";
                            // temp += "<td>" + user.lastname + "</td>";
                            // temp += "<td>" + user.email + "</td>";
                            // temp += "<td>" + user.username + "</td>";
                            // temp += "<td>" + user.roles + "</td>";
                            // temp += "<td><button class=\"btn btn-primary\" id=\"editButton\" usersData-bs-toggle=\"modal\" usersData-bs-target=\"#editModal\" onclick='editModal(" + user.id + ")'>Edit</button></td>";
                            // temp += "<td><button class=\"btn btn-danger\" id=\"deleteButton\" usersData-bs-toggle=\"modal\" usersData-bs-target=\"#deleteModal\" onclick='deleteModal(" + user.id + ")'>Delete</button></td></tr>";
                            temp += `<tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.lastname}</td>
                                <td>${user.email}</td>
                                <td>${user.username}</td>
                                <td>${user.roles}</td>
                                <td><button class="btn btn-primary" id="editButton" data-bs-toggle="modal" data-bs-target="#editModal" onclick='editModal(${user.id})'>Edit</button></td>
                                <td><button class="btn btn-danger" id="deleteButton" data-bs-toggle="modal" data-bs-target="#deleteModal" onclick='deleteModal(${user.id})'>Delete</button></td>
                                </tr>`
                        })
                        document.getElementById("usersData").innerHTML = temp;
                    }
                }
            )

        })
    $('a[data-bs-toggle="editModal"]').on('hidden', function() {
        $(this).data('editModal').$element.removeData();
    });
}
