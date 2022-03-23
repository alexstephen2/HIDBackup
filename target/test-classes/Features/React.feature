Feature: ReactJS Website Testing

@MainConcepts
Scenario: DocsTab verification
Given the user navigates to ReactJs Website
When the user opens the DOCS page
Then Highlight Main Concepts Links and download Sub link names to a file

@AdvanceGuides
Scenario: AdvanceGuideTab verification
Given the user navigates to ReactJs Website
When the user opens the DOCS page
Then Highlight Advanced Guide Links and download Sub link names to a file

@ScrollFunctionality
Scenario: Tutorials Tab Scroll Functionality
Given the user navigates to ReactJs Website
When the user opens the Tutorials page
And user scrolls to Topic "Inspecting the Starter Code"
Then Verify the Scroll Navigation Index Page
