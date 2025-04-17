@POEI25P2G4-92 @P2G4 @TNR
@REQ_POEI25P2G4-6
Feature: Accès à la page d'accueil
	#L'utilisateur doit pouvoir accéder à une page d’accueil;

	Background:
		#@POEI25P2G4-73
		Given I am on the Home page

	#L'utilisateur doit pouvoir accéder à une page d’accueil
	@POEI25P2G4-30 @POEI25P2G4-78 @P2G4 @TNR
	Scenario Outline: Accès à la page d'accueil --> Filtres articles
		When I click on the "<Tab>" tab
		Then I am redirected to the "<Expected Page>" products page
		
		  Examples:
		    | Tab       | Expected Page |
		    | Women     | Women         |
		    | Dresses   | Dresses       |
		    | T-Shirts  | T-Shirts      |
		
	#L'utilisateur doit pouvoir accéder à une page d’accueil
	@POEI25P2G4-28 @POEI25P2G4-78 @P2G4 @TNR
	Scenario: Accès à la page d'accueil --> Publicités
		When I click on an advertisement
		Then I am redirected to the PrestaShop partner site
		
	#L'utilisateur doit pouvoir accéder à une page d’accueil
	@POEI25P2G4-27 @POEI25P2G4-78 @P2G4 @TNR
	Scenario: Accès à la page d'accueil --> Blog
		When I click on the "BLOG" tab
		Then I am redirected to the PrestaShop blog site
		
	#L'utilisateur doit pouvoir accéder à une page d’accueil
	@POEI25P2G4-23 @POEI25P2G4-78 @P2G4 @TNR
	Scenario: Accès à la page d'accueil --> "Sign in"
		When I click on Sign in
		Then I am redirected to the Sign in page
		
	#L'utilisateur doit pouvoir accéder à la page d’accueil
	@POEI25P2G4-22 @POEI25P2G4-78 @P2G4 @TNR
	Scenario: Accès à la page d'accueil --> "Contact us"
		When I click on "Contact us"
		Then I am redirected to the "Contact us" page
		
