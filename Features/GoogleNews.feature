@googleNews
Feature: Google News

  Scenario: User is able to click news link
    Given User opens a browser "ff"
    And Navigates to the app "https://www.news.google.com"
		When user clicks on a news link from cnn
		Then user is on cnn webpage
		#panda panda panda
		#Afsheen was here
		#THIS IS THE DEV BRANCH