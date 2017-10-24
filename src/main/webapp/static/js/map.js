var map = new AMap.Map('container', {
    resizeEnable: true,
    zoom: 20,
    center: [118.642371, 32.036997]
});

var url='http://localhost:8080/';
var greenX = url+'api-bicycle-getX/1';
var greenY = url+'api-bicycle-getY/1';
var redX = url+'api-bicycle-getX/-1';
var redY = url+'api-bicycle-getY/-1';

var greenBicycleCurrentX,greenBicycleCurrentY;
var redBicycleCurrentX,redBicycleCurrentY;

Ajax(greenX, function(res) {
    greenBicycleCurrentX = JSON.parse(res);
    Ajax(greenY, function(res) {
        greenBicycleCurrentY = JSON.parse(res);
        initGreen();
    })
})

Ajax(redX, function(res) {
    redBicycleCurrentX = JSON.parse(res);
    Ajax(redY, function(res) {
        redBicycleCurrentY = JSON.parse(res);
        initRed();
    })
})


function initGreen() {
    for (var i = 0; i < greenBicycleCurrentX.length; i++) {
        marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            position: [greenBicycleCurrentX[i], greenBicycleCurrentY[i]]
        });
        marker.setMap(map);
    }
}


function initRed(){
    for (var i = 0; i < redBicycleCurrentX.length; i++) {
        marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png",
            position: [redBicycleCurrentX[i], redBicycleCurrentY[i]]
        });
        marker.setMap(map);
    }
}


function Ajax(url, callback) {
    var xhr = new XMLHttpRequest();

    xhr.open('GET', url, true);

    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                callback(xhr.responseText);
            }
        }
    }
}