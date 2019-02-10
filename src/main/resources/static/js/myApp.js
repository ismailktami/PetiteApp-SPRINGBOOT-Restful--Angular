var myApp=angular.module("myApp",[]);


myApp.controller("InscriptionController",function($scope,$http){
$scope.etudiant={};
$scope.errors=null;
$scope.mode={value:'form'}
$scope.saveEtudiant=function(){
    $http.post("etudiants",$scope.etudiant).success(function(data){
        if(!data.errors){
        $scope.etudiant=data;
         $scope.erros=null;  
         $scope.mode.value='confirm'; 
    }
        else
            {
                    $scope.errors=data;
                    $scope.etudiant=nul;

            }
    });
};

});

myApp.controller("ListEtudiantController",function($scope,$http){
$scope.pageEtudiants=null;
$scope.pageCourante=0;
$scope.size=5;
$scope.listEtudiant=function(){
    $http.get("listEtudiants?page="+$scope.pageCourante+"&size="+$scope.size).success(function(data){
        $scope.pageEtudiants=data;
    });
};

$scope.listEtudiant();

});

myApp.controller("IndexController",function($http,$scope){
$scope.menu=["Inscription","Listes","Utilisateurs","Logout"];
$scope.selectedmenu=null;

$scope.select=function(m){
$scope.selectedmenu=m;

};

});
