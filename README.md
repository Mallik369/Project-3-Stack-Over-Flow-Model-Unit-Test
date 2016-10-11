##Team Tree House Tech Degree Project 3 
### Stack Over Board Model Unit Test

  Stack Over Board is an Application similar to Website Stack Over Flow. There will be several “boards” which house different Topic areas and skill Levels.They have started, like most projects do, by defining the model that they will be using. They have decided that they better put some unit tests in place to ensure that the model is interacting the way that it is expected. 

The way things are currently defined all activities they have concerns about are coming from the User model is mentioned below. They’ve done their best to ensure that all activity happens from there using some access modifier techniques.

Since you know that you are testing the Unit of Work and not necessarily the implementation you have agreed to take on the task. The guidelines that they would like to see tested are listed in the Project instructions.

1.  Create a new Test Fixture for the User model in a separate but same package test directory structure.
    <hr>
    Test directory is created in `src/test/java`. `UserTest.java` lies in
    `src/test/java/com/teamtreehouse/techdegree/overboard/model`. 
    <hr>
2.  Write a test to ensure that the questioner’s reputation goes up by 5 points if their question is upvoted. 
    <hr>
    Test Method : `upVotingQuestionIncrementsQuestionersReputationByFivePoints()`.
    <hr>
3.  Write a test to assert that the answerer’s reputation goes up by 10 points if their answer is upvoted.
    <hr>
    Test Method :  `upVotingAnswerIncrementsAnswererReputationByTenPoints()`
    <hr>
4.  Write a test that that proves that having an answer accepted gives the answerer a 15 point reputation boost.
    <hr>
    Test Method : `questionerAcceptAnswerIncrementsAnswererReputationByFifteenPoints()`
    <hr>
5.  Using a test, ensure that voting either up or down is not allowed on questions or answers by the original author, you know 
    to avoid gaming the system. Ensure the proper exceptions are being thrown.
    <hr>
    Test Methods
    
    `questionerUpVotingQuestionIsNotAllowed()`
    
    `questionerDownVotingQuestionIsNotAllowed()`
    
    `answererUpVotingAnswerIsNotAllowed()`
    
    `answererDownVotingAnswerIsNotAllowed()`
    <hr>
6.  Write a test to make sure that only the original questioner can accept an answer. Ensure the intended messaging is being 
    sent to back to the caller.
    <hr>
    Test Method checks Orginal Questioner Accepts Answer is Accepted
    `questionerAcceptingAnswerToHisQuestionSetsAnswerIsAccepted()`
    
    Test Method Checks UnAuthorized Questioner Accepting Answer is Throws AnswerAcceptanceException
    `UnAuthorizedQuestionerAcceptingAnswerIsNotAllowed( )`
    <hr>
7.  Reviewing the User.getReputation method may expose some code that is not requested to be tested in the Meets Project instructions. 
    Write the missing test.
    
    a)  Test to Down Voting Question does not affect the reputation of Questioner
    `downVotingQuestionDoesNotAffectReputation()`
     
    b)  Test to Down Voting Answer decreases the Answerer reputation by one point
    `downVotingAnswerDecrementsAnswererReputationByOnePoint()`
    
    
