@POEI25P2G4-90 @P2G4 @TNR
@REQ_POEI25P2G4-1
Feature: Réinitialisation de mot de passe
	#En tant qu'
	#Utilisateur
	#Je souhaite
	#Ré-initialiser mon mot de passe oublié
	#Afin de
	#D’accéder à mon compte client
	#Règles de gestion :
	#RG1 : Dans la page d'authentification, un lien "Forgot your password?" redirige l'utilisation vers la page de
	#réinitialisation du compte. Un champ permet de saisir l'email du compte, et un bouton "Retrieve Password"
	#génére l'envoi d'un mail de réinitialisation
	#RG2 : Le mail contient un lien de réinitialisation permettant l'envoi d'un mail avec un nouveau mot de passe

	#Un champ permet de saisir l'email du compte, et un bouton "Retrieve Password" génére l'envoi d'un mail de réinitialisation.
	#
	#Le mail contient un lien de réinitialisation permettant l'envoi d'un mail avec un nouveau mot de passe
	@POEI25P2G4-29 @POEI25P2G4-80 @P2G4 @TNR
	Scenario: Réinitialisation de mot de passe
		Given I am on the "Password reset" page
		When I enter my registered email "registered@email.com"
		And I click the "Reset Password" button
		Then a password reset email should be sent to my registered email
		And the email should contain a reset link
		
