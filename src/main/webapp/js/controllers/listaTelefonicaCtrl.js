angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI, serialGenerator) {
			$scope.app = "Lista Telefônica";
			$scope.contatos = [];
			$scope.operadoras = [];

			console.log(serialGenerator.generate());
			
			var carregarContatos = function () {
				contatosAPI.getContatos().success(function (data) {
					$scope.contatos = data;
				}).error(function (data, status) {
					$scope.error = "Não foi possivel carregar os dados";
				});
			};

			var carregarOperadoras = function () {
				operadorasAPI.getOperadoras().success(function (data) {
					$scope.operadoras = data;
				});
			};

			$scope.adicionarContato = function (contato) {
				contato.serial = serialGenerator.generate();
				contato.data = new Date();
				contatosAPI.saveContato(contato).success(function (data) {
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