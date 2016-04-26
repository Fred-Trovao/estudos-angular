angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, $http) {
			$scope.app = "Lista Telefônica";
			$scope.contatos = [];
			$scope.operadoras = [];

			var carregarContatos = function () {
				$http.get("http://localhost:8080/contatos").success(function (data) {
					$scope.contatos = data;
				}).error(function (data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			};

			var carregarOperadoras = function () {
				$http.get("http://localhost:8080/operadoras").success(function (data) {
					$scope.operadoras = data;
				});
			};

			$scope.adicionarContato = function (contato) {
				contato.data = new Date();
				$http.post("http://localhost:8080/contatos", contato).success(function (data) {
					delete $scope.contato;
					$scope.contatoForm.$setPristine();
					carregarContatos();
				});
			};

			$scope.apagarContatos = function(contatos){
				$scope.contatos = contatos.filter(function(contato){
					return !contato.selecionado;
				})
			};

			$scope.isContatoSelecionado = function (contatos) {
				return contatos.some(function(contato){
					return contato.selecionado;
				});
			};

			$scope.ordenarPor = function(campo){
				$scope.criterioDeOrdenacao = campo;
				$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
			};
			
			carregarContatos();
			carregarOperadoras();

		})