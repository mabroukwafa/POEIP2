@POEI25P2G4-90 @P2G4 @TNR
@REQ_POEI25P2G4-20
Feature: Espace client non sécurisé
	#En saisissant un mot de passe erroné, l'utilisateur peut tout de même accéder à son espace.
	#Test effectué avec plusieurs mots de passe différents

	Background:
		#@POEI25P2G4-74
		Given I am on the "Sign In" page

	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche
	@POEI25P2G4-54 @POEI25P2G4-80 @P2G4 @TConf @TNR
	Scenario: Connexion KO
		When I enter "valid.email@example.com" in the <Email address> field
		And I enter "InvalidPassword01" in the <Password> field
		And I click <Sign in>
		Then I should see "Authentication failed." error message
		
