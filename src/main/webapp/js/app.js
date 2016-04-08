function searchController($scope, $http) {
    $scope.is_visible = true;
    var service_uri = 'http://antibyteapps.orhundalabasmaz.com/services/dictionary/';
    // var service_uri = 'http://localhost:8080/AntiByteApps/services/dictionary/';
    $scope.search = function () {
        $scope.result = '';
        var word = $scope.searchContent;
        if (word == undefined || word == '') return;
        var request_uri = service_uri + word;
        $http.get(request_uri).success(
            function (response) {
                $scope.result = response;
            }
        );
    };
}
