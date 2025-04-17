@POEI25P2G4-90 @P2G4 @TNR
@REQ_POEI25P2G4-15
Feature: Connexion à un compte client
	#En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG1 : La page d'authentification est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche

	Background:
		#@POEI25P2G4-74
		Given I am on the "Sign In" page

	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche
	@POEI25P2G4-54 @POEI25P2G4-80 @P2G4 @TConf @TNR
	Scenario: Connexion KO
		When I enter "valid@gmail.com" in the <Email address> field
		And I enter "InvalidPassword01" in the <Password> field
		And I click <Sign in>
		Then I should see "Authentication failed." error message
		
	#En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG1 : La page d'authentification est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu
	@POEI25P2G4-53 @POEI25P2G4-80 @P2G4 @TNR
	Scenario: Connexion OK
		When I enter "valid@gmail.com" in the <Email address> field
		And I enter "valid123" in the <Password> field
		And I click <Sign in>
		Then I should be redirected to <My Account> page
		And I should see my name in the menu bar
		
