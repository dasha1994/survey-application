package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dto.CalculatedFieldDto;
import com.agile.mentorship.surveyApplication.dto.ResponseDto;
import com.agile.mentorship.surveyApplication.dto.SurveyTransactionDto;

import java.util.*;

public class SurveyTransactionService {
    private Map<Integer, String> surveyIdName = new HashMap<>();

    public SurveyTransactionService() {
        surveyIdName.put(1, "Student 6-12");
        surveyIdName.put(2, "Teacher/Staff");
        surveyIdName.put(3, "Home");

    }
    public List<SurveyTransactionDto> generateSurveyTransactions() {
        List<String> unitNames = Arrays.asList(
                "Appoquinimink High School #24","Brick Mill Elementary School #21","Bunker Hill Elementary School #28","Cedar Lane Elementary School #11","Loss (Olive B.) Elementary School #20","Meredith (Everett) Middle School #17","Middletown High School #18","Old State Elementary School #32","Redding (Louis L.) Middle School #16","Silver Lake Elementary School #10","Townsend Elementary School #14","Waters (Alfred G.) Middle School #23","Positive Change Academy #150 [Brandywine Community School (BCS) and Twilight Academy Program (TAP) #150]","Brandywine High School #190","Carrcroft Elementary School #112","Claymont Elementary School #151","Concord High School #194","DuPont (Pierre S.) Middle School #170","Forwood Elementary School #124","Hanby Elementary School #110","Harlan (David W.) Elementary School #156","Lancashire Elementary School #128","Lombardy Elementary School #130","Maple Lane Elementary School #132","Mount Pleasant Elementary School #176","Mount Pleasant High School #196","Springer Middle School #178","Talley Middle School #180","Beacon Middle School #724","H. O. Brittingham Elementary School #710","Mariner Middle School #720","Milton Elementary School #721","Rehoboth Elementary School #722","Shields (Richard A.) Elementary School #712","Booker T. Washington Elementary School #636","Central Middle School #644","Dover High School #648","East Dover Elementary School #632","Fairview Elementary School #638","Hartly Elementary School #640","Henry (William) Middle School","Kent County Secondary ILC #655","North Dover Elementary School #635","South Dover Elementary School #634","Towne Point Elementary School #642","Academy Of Dover Charter School #584","Delaware Design-Lab High School","Early College High School at Delaware State University #4040","First State Military Academy #4055","Odyssey Charter School","Providence Creek Academy Charter School","Castle Hills Elementary School #412","Downie (Carrie) Elementary School #410","Eisenberg (Harry O.) Elementary School #456","New Castle Elementary School #432","Pleasantville Elementary School #418","Southern Elementary School #427","Wilbur (Kathleen H.) Elementary School #422","Wilmington Manor Elementary School #420","Bedford (Gunning) Middle School #470","McCullough (Calvin R. ) Middle School #476","Read (George) Middle School #474","Delmar Middle School #733","Delmar Senior High School #730","Lake Forest Central Elementary School #669","Lake Forest East Elementary School #658","Lake Forest North Elementary School #660","Lake Forest South Elementary School #662","Chipman (W.T.) Middle School #664","Lake Forest High School #665","Laurel Middle School #782","Banneker (Benjamin) Elementary School #668","Mispillion Elementary School #673","Ross (Lulu M.) Elementary School #672","Milford Central Academy #675","POLYTECH High School #652","Baltz (Austin D.) Elementary School #252","Forest Oak Elementary School #240","Heritage Elementary School #242","Highlands Elementary School #244","Lewis (William C.) Dual Language Elementary School #246","Linden Hill Elementary School #250","Marbrook Elementary School #256","Mote (Anna P.) Elementary School #264","North Star Elementary School #270","Richardson Park Elementary School #254","Richey Elementary School #260","Warner Elementary School #266","duPont (Alexis I.) Middle School #274","duPont (H.B.) Middle School #276","Skyline Middle School #280 #770","Stanton Middle School #282","Dickinson (John) High School #290","duPont (Alexis I.) High School #292","McKean (Thomas) High School #294","First State School #530","Brandywine Springs School #261","Cab Calloway School of the Arts #286","Conrad Schools of Science #284","Sussex Technical High School","Phillis Wheatley Elementary School #779","Woodbridge Middle School #775","Woodbridge High School #780","Dunbar (Paul Laurence) Elementary School","Shortlidge (Evan G.) Academy #248","Kent County Community School #650","Morris (Evelyn I.) Early Childhood #670","Woodbridge Early Child Education Center #776","Meadowood Program #516","Richardson Park Learning Center","William Henry Middle School #646","Milford Senior High School #678","Bush (Charles W.) Pre-School #510","Cedar Lane Early Childhood Center #22","Townsend Early Childhood Center #27","The Bayard School","Newark High School","Marshall (Thurgood) Elementary School","Christiana High School","Kirk (George V.) Middle School","Wilson (Etta J.) Elementary School","Oberle (William) Elementary School","Shue Medill Middle School","Gauger Cobbs Middle School","Glasgow High School","Odyssey Charter School Lower","Brader (Henry M.) Elementary School","Christina Early Education Center","Gallaher (Robert S.) Elementary School","Networks","Brennen School (The)","Maclary (R. Elisabeth) Elementary School","McVey (Joseph M.) Elementary School","West Park Place Elementary School","Smith (Jennie E.) Elementary School","Delaware School for the Deaf","Stubbs (Frederick Douglass) Elementary School","Jones (Albert H.) Elementary School","Pulaski (Casimir) Elementary School","Pyle (Sarah) Academy","Keene (William B.) Elementary School","Brookside Elementary School","Downes (John R.) Elementary School","Leasure (May B.) Elementary School","Elbert Palmer Elementary School","Douglass School","The Bancroft School","Penn (William) High School #490","TEST Redding (Louis L.)Middle School","Polytech Training","Test","North Laurel Early Learning Academy #752","Simpson (W.B.) Elementary School #620","Long Neck Elementary School #690","Brown (W. Reily) Elementary School #622","Star Hill Elementary School #618","Welch (Major George S.) Elementary School #612","Frear (Allen) Elementary School #610","Stokes (Nellie Hughes) Elementary School #616","Love Creek Elementary School #718","MOT Charter School","Fifer (Fred) Middle School #625","Postlethwait (F. Niel) Middle School #621","Dover Air Force Base Middle School #628","Caesar Rodney High School #626","Cape Henlopen High School #726","Delaware Military Academy #578","Appoquinimink Early Childhood Center ","Spring Meadow Early Childhood Center #29","Charlton (John S.) School #630","Kent Elementary Intensive Learning Center #615","McIlvaine (J. Ralph) Early Childhood Center #611","Sussex Consortium ","Appoquinimink Preschool Center #13","Data Test","Academia Antonia Alonso #4045","Carver (G.W.) Educational Center #689","Clayton Intermediate School #696","East Side Charter School #571","Ennis (Howard T.) School #750","Indian River High School #746","Joseph Brumskill Early Childhood Assistance Program (ECAP) #510","Laurel Elementary School #783","Laurel Senior High School #756","Lorewood Grove Elementary School #35","Millsboro Middle School #741","Moore (John Bassett) School #686","North Georgetown Elementary  #692","Southern Delaware School of the Arts #749","Sussex Central High School #748","The Colwyck Center #450","Cooke (William F. Jr.) Elementary #271","MosaicProdTestD01School01","MosaicProdTestD01School02","MosaicProdTestD02School01","nvDeleteSchool","Delete School - test","Developer and Support Unit","Early Years Program #526","Red Clay Alternative Education","evgsmtptest","Mosaic Test","Evgeniy Mosaic Test","Delaware School Test","test","elementary_school","Odessa High School #34","Charter School of New Castle #579","Sussex Academy #576","Leach (John G.) School #514","The Wallin School #522","Delaware Early Childhood Center #663","Test Prod High School 1","Test Prod High School 2","Test Prod Elementary School 1","Magnolia Middle School","Robinson (David E.) Elementary School","Virtual Program","Cantwell Bridge Middle School"
        );
        List<SurveyTransactionDto> list = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            String id = String.valueOf(i);
            SurveyTransactionDto dto = new SurveyTransactionDto();
            dto.setId(i);
            dto.setChronoOrderTagId(getRandomId(4));
            dto.setSurveyId(getRandomId(4));
            dto.setSurveyName(surveyIdName.get(dto.getSurveyId()));
            dto.setUnitName(unitNames.get(getRandomId(219)));
            dto.setUnitId(getRandomId(200));
            dto.setContactId(id);
            dto.setSessionLinked(id);
            dto.setDateCreated(new Date());
            dto.setDateSubmitted(new Date());

            dto.setResponses(generateResponses());
            dto.setCalculatedFields(generateCalculatedFields());
            list.add(dto);
        }
        return list;
    }

    private int getRandomId(int upperBound) {
        Random random = new Random();
        return random.ints(1,upperBound).findAny().getAsInt();
    }

    private List<ResponseDto> generateResponses() {
        List<Integer> questionIds = Arrays.asList(
                2, 3, 5, 7, 9, 18, 11, 41, 25, 38, 44, 30, 21, 37, 42, 29, 28, 10, 65, 35, 66, 15, 8, 19, 17, 23, 24, 20, 34, 36, 32, 12, 31, 43, 14, 16, 26, 22, 13, 39, 33, 27, 45, 57, 48, 67, 51, 50, 55, 47, 46, 56, 54, 53, 52, 49, 62, 61, 64, 59, 58, 60, 68, 63, 72, 71, 70, 69);
        List<String> questionTexts = Arrays.asList(
                "What grade are you in?","What is your gender?","Which cultural group or ethnicity do you most closely identify with?","Do you agree to complete this survey?","I can do most things if I try.",
                "At my school, there is a teacher or some other adult who listens to me when I have something to say.","There is a purpose to my life.","How much do you feel ENTHUSIASTIC right now?","I have a friend my age who helps me when I'm having a hard time.","How much do you feel ENERGETIC right now?","Since yesterday how much have you felt APPRECIATIVE?","I try to understand what other people go through.","There is a feeling of togetherness in my family.","Overall, I expect more good things to happen to me than bad things.","Since yesterday how much have you felt GRATEFUL?","I feel bad when someone gets his or her feelings hurt.","I can deal with being told no.","There are many things that I do well.","When was the last time you were seen by a dentist?","Each day I look forward to having a lot of fun.","How many times have you been recognized for something positive at school?","I try to answer all the questions asked in class.","I can work out my problems.","At my school, there is a teacher or some other adult who believes that I will be a success.","At my school, there is a teacher or some other adult who always wants me to do my best.","I have a friend my age who really cares about me.","I have a friend my age who talks with me about my problems.","My family members really help and support one another.","I think before I act.","I usually expect to have a good day.","I can wait for what I want.","I understand my moods and feelings.","I try to understand how other people feel and think.","Since yesterday how much have you felt THANKFUL?","When I do not understand something, I ask the teacher again and again until I understand.","When I try to solve a math problem, I will not stop until I find a final solution.","I accept responsibility for my actions.","My family really gets along well with each other.","I understand why I do what I do.","How much do you feel ACTIVE right now?","I don't bother others when they are busy.","When I make a mistake I admit it.","How safe do you feel when you are at school?","In the past month, my life felt pointless.","In the past month, I was tense and uptight.","How many siblings do you have?","In the past month, I was easily irritated because things got in the way of what I was doing.","In the past month, I felt sad and down.","In the past month, I was easily annoyed and sensitive.","In the past month, I worried that I would embarrass myself in front of others.","In the past month, I had a hard time breathing because I was anxious.","In the past month, I was scared for no good reason.","In the past month, I felt unimportant.","In the past month, it was hard for me to get excited about anything.","In the past month, it was hard for me to cope and I thought I would panic.","In the past month, I had a hard time relaxing.","I feel safe at this school.","The teachers at this school treat students fairly.","Do you have a disability? (check all that apply)","I am happy to be at this school.","I feel close to people at this school.","I feel like I am part of this school.","If you had to choose just one flavor of ice cream for one year, which one would you select?","I would describe my satisfaction with my LIFE OVERALL as:<br><span style=\"font-size: 14px; color: #E0D233\">0 = completely dissatisfied ... 100 = completely satisfied</span>","The questions in this survey will help my school to better support all students.","The questions in this survey were relevant to all students' life experiences.","These questions helped me to privately tell adults about what is going on in my life.","How many questions in this survey did YOU answer honestly?"
        );
        List<String> responseTexts = Arrays.asList(
                "7th", "Female", "Asian", "Yes, I will take the survey", "Very much true of me", "A little true of me", "Not at all true of me", "Not at all", "A little true of me", "Very little", "Somewhat", "A little true of me", "Pretty much true of me", "A little true of me", "Quite a lot",
                "A little true of me", "Not at all true of me", "Very much true of me", "5 or more years", "Not at all true of me", "1", "Not at all true of me", "A little true of me", "A little true of me", "Pretty much true of me", "A little true of me", "A little true of me", "A little true of me", "Pretty much true of me",
                "Pretty much true of me", "A little true of me", "Not at all true of me", "Not at all true of me", "Very little", "Pretty much true of me", "Not at all true of me", "Pretty much true of me", "A little true of me", "Pretty much true of me", "Not at all", "A little true of me", "Pretty much true of me", "Neither safe nor unsafe", "A little true of me", "Pretty much true of me", "4", "Pretty much true of me", "A little true of me", "A little true of me", "Not at all true of me", "Not at all true of me", "Not at all true of me", "Pretty much true of me", "A little true of me", "Not at all true of me", "Not at all true of me", "Neither disagree nor agree", "Neither disagree nor agree", "Visual problems", "Strongly agree", "Neither disagree nor agree", "Neither disagree nor agree", "Chocolate", "No, never", "Neither disagree nor agree", "Agree", "Neither disagree nor agree", "Most questions"
        );
        List<Integer> responseScores = Arrays.asList(
               0,0,0,0,4,2,1,1,2,2,3,2,3,2,4,2,1,4,1,1,0,1,2,2,3,2,2,2,3,3,2,1,1,2,3,1,3,2,3,1,2,3,3,2,3,0,3,2,2,1,1,1,3,2,1,1,3,3,0,5,3,3,0,1,3,4,3,0
        );
        List<ResponseDto> list = new ArrayList<>();
        for (int i = 0; i < questionIds.size(); i++) {
            ResponseDto dto = new ResponseDto();
            dto.setQuestionId(questionIds.get(i));
            dto.setQuestionText(questionTexts.get(i));
            dto.setResponse(responseTexts.get(i));
            dto.setResponseScore(responseScores.get(i));
            list.add(dto);
        }
        return list;
    }

    private List<CalculatedFieldDto> generateCalculatedFields() {
        List<CalculatedFieldDto> list = new ArrayList<>();
        List<String> fieldNames = Arrays.asList(
        "Z-RAW","Z-CAT","SS-RAW","SS-CAT","SE-RAW","SE-CAT","SCS-TS","SCS-SD","SCS-RAW","SCS-MEAN","SCS-CAT","SC-RAW","SC-CAT","SA-RAW","SA-CAT","RC-CAT","PS-RAW","PS-CAT","PD-TS","PD-SD","PD-RAW","PD-MEAN","PD-CAT","P-RAW","P-CAT","O-RAW",
        "O-CAT","NUM-STRENGHTS","LS-TS","LS-SD","LS-RAW","LS-MEAN","LS-CAT","G-RAW","G-CAT","FC-RAW","FC-CAT","ER-RAW","ER-CAT","EL-TS","EL-SD","EL-RAW","EL-MEAN","EL-CAT","EC-TS","EC-SD","EC-RAW","EC-MEAN","EC-CAT","E-RAW","E-CAT","DF-CAT","COVI-TS","COVI-SD","COVI-RAW","COVI-MEAN","COVI-CAT","BIS-TS","BIS-SD","BIS-RAW","BIS-MEAN","BIS-CAT","BIO-TS","BIO-SD",
                "BIO-RAW","BIO-MEAN","BIO-CAT","AUTH-RAW","AUTH-CAT");

        List<String> values= Arrays.asList("3","7","2","4","10","1","50.0","3.9","17","17.0","3","7","2","5","3","1","6","2","50.0","10.5","22","22.0","3","5","3","6","3","1","61.06481481481482","21.6","94","70.1","1","9","2","7","2","7","2","39.61538461538461","7.8","19","27.1","4","36.833333333333336","6.0","19","26.9","4","5","3","4","36.4622641509434","21.2","78","106.7","4","40.33333333333333","6.0","20","25.8","4","38.13559322033898","5.9","20","27.0","4","1","3");


        for (int i = 0; i < fieldNames.size(); i++) {
            CalculatedFieldDto dto = new CalculatedFieldDto();
            dto.setName(fieldNames.get(i));
            dto.setValue(Double.parseDouble(values.get(i)));
            list.add(dto);
        }
        return list;
    }
}
