package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Mallikarjuna on 10/11/2016.
 */
public class UserTest {

    private Board mBoard;
    private User mQuestionUser;
    private User mAnswerUser;
    private User mBoardUser;
    private Question mQuestion;
    private Answer mAnswer;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        mBoard = new Board("Java");
        mQuestionUser = mBoard.createUser("Questioner");
        mAnswerUser = mBoard.createUser("Answerer");
        mBoardUser = mBoard.createUser("BoardUser");
        mQuestion = mQuestionUser.askQuestion("Java Interfaces can extend");
        mAnswer = mAnswerUser.answerQuestion(mQuestion,"Multiple Interfaces");
    }

    @Test
    public void upVotingQuestionIncrementsQuestionersReputationByFivePoints() throws Exception {
        //Action : mBoardUser can UpVote the Question
        mBoardUser.upVote(mQuestion);

        //Assert : Verify Questioners reputation Goes up by five points
        assertEquals(5,mQuestionUser.getReputation());
    }

    @Test
    public void downVotingQuestionDoesNotAffectReputation() throws Exception {
        //Action : mtBoardUser DownVote the Question
        mBoardUser.downVote(mQuestion);

        //Assert: Verify Questioners reputation is not affected
        assertEquals(0,mQuestionUser.getReputation());
    }

    @Test
    public void upVotingAnswerIncrementsAnswererReputationByTenPoints() throws Exception {
        //Action : mQuestionUser can Upvote answer by mBoardUser
        mQuestionUser.upVote(mAnswer);

        //Assert : Verify Answers reputation Increments by 10
        assertEquals(10,mAnswerUser.getReputation());
    }

    @Test
    public void downVotingAnswerDecrementsAnswererReputationByOnePoint() throws Exception {
        //Action : mBoarduser downVote Answer
        mBoardUser.downVote(mAnswer);

        //Assert: Verify Answers reputation Decrements by 1
        assertEquals(-1,mAnswerUser.getReputation());
    }

    @Test
    public void questionerAcceptAnswerIncrementsAnswererReputationByFifteenPoints() throws Exception {
        //Action : mQuestionUser accepts the answer given by mAnswerUser
        mQuestionUser.acceptAnswer(mAnswer);

        //Assert : Verify Answerer's a 15 point reputation Boost
        assertEquals(15,mAnswerUser.getReputation());
    }

    @Test
    public void questionerUpVotingQuestionIsNotAllowed() throws Exception {
        // Voting Exception is Catches Inside Class when questioner UpVotes his Question
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");
        //Action : mQuestionUser is UpVoting Question
        mQuestionUser.upVote(mQuestion);
    }

    @Test
    public void questionerDownVotingQuestionIsNotAllowed() throws Exception {
        //Voting Exception is Catches Inside Class when questioner  DownVotes his Question
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself");
        //Action: mQuestionUser is DownVoting Question
        mQuestionUser.downVote(mQuestion);
    }

    @Test
    public void answererUpVotingAnswerIsNotAllowed() throws Exception {
        //Voting Exception is Catches Inside Class when Answerer UpVotes his Answer
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself");
        //Action : mAnswerUser UpVoting his answer
        mAnswerUser.upVote(mAnswer);
    }

    @Test
    public void answererDownVotingAnswerIsNotAllowed() throws Exception {
        //Voting Exception is Catches Inside Class when Answerer DownVotes his Answer
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself");
        //Action: mAnswer DownVoting his answer
        mAnswerUser.downVote(mAnswer);
    }

    @Test
    public void UnAuthorizedQuestionerAcceptingAnswerIsNotAllowed( )throws Exception {
        String message = String.format("Only %s can accept this answer as it is their question",
                mQuestionUser.getName());
        //Answer Acceptance Exception is catches when Other Board User is accepting Original Questioner Answer
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage(message);
        //Action : mBoardUser(Unauthorized Questioner) accepting Answer
        mBoardUser.acceptAnswer(mAnswer);

    }

    @Test
    public void questionerAcceptingAnswerToHisQuestionSetsAnswerIsAccepted() throws Exception {
        //Action: mQuestionUser accepts answer
        mQuestionUser.acceptAnswer(mAnswer);
        String message = String.format("%s accept answer to question",
                mQuestionUser.getName());

        //Assert : Verify
        assertTrue(message,mAnswer.isAccepted());
    }
}