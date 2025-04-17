@POEI25P2G4-90 @P2G4 @TNR
@REQ_POEI25P2G4-2
Feature: Déconnexion
	#En tant qu'
	#Utilisateur
	#Je souhaite
	#Me déconnecter
	#Afin de
	#Ne plus pouvoir accéder à mon espace client
	#Règles de gestion :
	#RG1 : Dans l'espace la barre menu, un lien "Sign out" déclenchela déconnexion
	#RG2 : La page d'authentification s'affiche et le lien "Sign in" remplace le lien "Sign out" dans la barre menu

	Background:
		#@POEI25-719
		Given I am on the "My Account" page

	#En tant qu' Utilisateur Je souhaite Voir le logo du Site "Your Logo What a new experience" en gris Règles de gestion : 
	#
	#RG1 : Le logo contient un lien qui doit rediriger le site sur la page accueil 
	#
	#RG2 : Le logo doit être présent sur toutes les pages du site
	@POEI25P2G4-31 @POEI25P2G4-80 @P2G4 @TNR
	Scenario: Déconnexion
		When I click on the "Sign out" link
		Then I should be redirected to the authentication page
		And the menu bar should show "Sign in" instead of "Sign out"
		
