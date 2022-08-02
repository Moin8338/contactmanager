
var data;
function run() {
  
    // Creating Our XMLHttpRequest object 
    var xhr = new XMLHttpRequest();

    // Making our connection  
    var url = 'http://localhost:8080/user/getproducts';
    xhr.open("GET", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')

    // function execute after request is successful 
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(JSON.parse(this.responseText));
           return JSON.parse(this.responseText);
        }
    }
    // Sending our request 
    xhr.send();
}



(function () {

    var resources=run();

    console.log("resources");
    console.log(resources);


    var recent_follow = [
        {
            user_name: "@coffee_time",
            user_id: 1
        },
        {
            user_name: "@lets_create",
            user_id: 2
        },
        {
            user_name: "@devthings",
            user_id: 3
        },
        {
            user_name: "@beast_design",
            user_id: 4
        },
        {
            user_name: "@holahola",
            user_id: 5
        },
        {
            user_name: "@moinuddin",
            user_id: 6
        },
        {
            user_name: "@its_me_moin",
            user_id: 7
        },
        {
            user_name: "@coffee_time",
            user_id: 8
        },
        {
            user_name: "@lets_create",
            user_id: 9
        },
        {
            user_name: "@devthings",
            user_id: 10
        },
        {
            user_name: "@beast_design",
            user_id: 11
        },
        {
            user_name: "@holahola",
            user_id: 12
        },
        {
            user_name: "@moinuddin",
            user_id: 13
        },
        {
            user_name: "@its_me_moin",
            user_id: 14
        }

    ];

    angular.module('dashboard', [])
        .controller('searchitems', searchitems)
        .controller('viewController', viewController);
    searchitems.$inject = ['$scope'];
    viewController.$inject = ['$scope'];

    function searchitems($scope) {
        $scope.templetes = resources;
        $scope.recent_follow = recent_follow;
    };

    function viewController($scope) {
        $scope.item = resources;
    };
})();
