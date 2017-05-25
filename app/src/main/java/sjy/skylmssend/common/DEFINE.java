package sjy.skylmssend.common;

public class DEFINE {
	public static final Boolean SLIDE_FLAG 			= true;  												// 슬라이드 메뉴 : true  , 슬라이드 메뉴 안쓸때 : false

	public static final String GCM_ID 				= "";  													// GCM ID
	//public static final String SERVER 				= "http://118.220.189.201:3030/api/";					// LOCAL SERVER
	public static final String SERVER 				= "https://gwmobile.doallpmis.com/api/";						// DIS SERVER
	public static final String IMGSERVER 			= "https://gwservice.doallpmis.com/GWImg/GANYMEDEJP/";						// DIS IMG SERVER
    public static final String PROFILE_IMGSERVER 			= "https://gatewaretest.doallpmis.com/Photo/";						// DIS IMG SERVER

	public static final String TEST 								= "test1";     										// 테스트
	public static final String DO_LOGIN 							= "workers/login";     										// 로그인
	public static final String DO_JOIN								= "workers/register";     										// 회원가입
	public static final String UP_MPW_MST_SELECT 					= "workers/select";     							// 작업원정보조회
	public static final String UP_MOBILE_MPW_CHK_LIST_FOR_LBR 		= "workers/inout/list";     						// 입퇴장시간조회 List
	public static final String UP_SYS_PJT_MST_LIST					= "projects/list";     								// 프로젝트조회
	public static final String SYSTEMS_ENTIRECODE_LIST				= "systems/entirecode/list";
	public static final String SYSTEMS_ENTIRECODE_SELECT			= "systems/entirecode/select";


/*
* CODE
* */

	//공통 코드
	public static final String SUCCESS       				= "success";		//성공 : true , 실패 : false
	public static final String RESULT       				= "result";			//SUCCESS가 true일때 LIST 배열 생성
	public static final String ERROR       					= "ERROR";			//SUCCESS가 false일때 error code

	//   MY PROFILE
	public static final String MPW_IDX       				= "MPW_IDX";
	public static final String MPW_CHK_IDX       			= "MPW_CHK_IDX";
	public static final String LBR_IDX       				= "LBR_IDX";
	public static final String MST_PJT_COD       			= "MST_PJT_COD";
	public static final String PJT_COD       				= "PJT_COD";
	public static final String LBR_GUID       				= "LBR_GUID";
	public static final String LBR_NM_READ       			= "LBR_NM_READ";
	public static final String LBR_LAST_NM_READ       		= "LBR_LAST_NM_READ";
	public static final String LBR_FIRST_NM_READ       		= "LBR_FIRST_NM_READ";
	public static final String LBR_NM       				= "LBR_NM";
	public static final String LBR_LAST_NM       			= "LBR_LAST_NM";
	public static final String LBR_FIRST_NM       			= "LBR_FIRST_NM";
	public static final String GENDER       				= "GENDER";
	public static final String RFID_NO       				= "RFID_NO";
	public static final String RFID_LOST_YN       			= "RFID_LOST_YN";
	public static final String FINGER_VEIN_NO       		= "FINGER_VEIN_NO";
	public static final String NATL_COD       				= "NATL_COD";
	public static final String COM_IDX       				= "COM_IDX";
	public static final String COM_NM       				= "COM_NM";
	public static final String COMPANY_STEP       			= "COMPANY_STEP";
	public static final String STEP1_COM_IDX       			= "STEP1_COM_IDX";
	public static final String STEP1_COM_NM       			= "STEP1_COM_NM";
	public static final String STEP2_COM_IDX       			= "STEP2_COM_IDX";
	public static final String STEP2_COM_NM       			= "STEP2_COM_NM";
	public static final String STEP3_COM_IDX       			= "STEP3_COM_IDX";
	public static final String STEP3_COM_NM      			= "STEP3_COM_NM";
	public static final String STEP4_COM_IDX       			= "STEP4_COM_IDX";
	public static final String STEP4_COM_NM       			= "STEP4_COM_NM";
	public static final String TRADE_IDX       				= "TRADE_IDX";
	public static final String TRADE_NM       				= "TRADE_NM";
	public static final String FIELD_IDX       				= "FIELD_IDX";
	public static final String FIELD_NM       				= "FIELD_NM";
	public static final String STAFF_TYP       				= "STAFF_TYP";
	public static final String SECT_COD       				= "SECT_COD";
	public static final String SECT_NM       				= "SECT_NM";
	public static final String PHOTO_FILE_NM       			= "PHOTO_FILE_NM";
	public static final String PHOTO_FILE_SIZE       		= "PHOTO_FILE_SIZE";
	public static final String MPW_CHK_PHOTO_FILE       	= "MPW_CHK_PHOTO_FILE";
	public static final String MOBILE_NO       				= "MOBILE_NO";
	public static final String PHONE_NO       				= "PHONE_NO";
	public static final String SSN_NO_A       				= "SSN_NO_A";
	public static final String SSN_NO_B       				= "SSN_NO_B";
	public static final String RETIRE_DEDUCT_YN       		= "RETIRE_DEDUCT_YN";
	public static final String UNEMPL_INSUR_YN       		= "UNEMPL_INSUR_YN";
	public static final String UNEMPL_INSUR_DSCP       		= "UNEMPL_INSUR_DSCP";
	public static final String HEALTH_INS_YN       			= "HEALTH_INS_YN";
	public static final String HEALTH_INS_DSCP       		= "HEALTH_INS_DSCP";
	public static final String ANNUITY_INS_YN       		= "ANNUITY_INS_YN";
	public static final String ANNUITY_INS_DSCP       		= "ANNUITY_INS_DSCP";
	public static final String SOCIAL_INS_YN       			= "SOCIAL_INS_YN";
	public static final String BLOOD_TYP       				= "BLOOD_TYP";
	public static final String BLOOD_TYP_ETC       			= "BLOOD_TYP_ETC";
	public static final String BLOOD_TYP_NM       			= "BLOOD_TYP_NM";
	public static final String BLOOD_PRESS_SYST       		= "BLOOD_PRESS_SYST";
	public static final String BLOOD_PRESS_DIAST       		= "BLOOD_PRESS_DIAST";
	public static final String BIRTH       					= "BIRTH";
	public static final String LIC       					= "LIC";
	public static final String ADDR       					= "ADDR";
	public static final String MPW_START_DD       			= "MPW_START_DD";
	public static final String MPW_END_DD       			= "MPW_END_DD";
	public static final String MPW_CNT       				= "MPW_CNT";
	public static final String CARR_YY       				= "CARR_YY";
	public static final String CARR_MM       				= "CARR_MM";
	public static final String SFTY_EDU_DD       			= "SFTY_EDU_DD";
	public static final String ACCESS_YN       				= "ACCESS_YN";
	public static final String NO_ACCESS_CAUSE       		= "NO_ACCESS_CAUSE";
	public static final String RMK       					= "RMK";
	public static final String STAFF_NO       				= "STAFF_NO";
	public static final String STAFF_SR_NO       			= "STAFF_SR_NO";
	public static final String PSPT_NO       				= "PSPT_NO";
	public static final String PSPT_START_DD       			= "PSPT_START_DD";
	public static final String PSPT_END_DD       			= "PSPT_END_DD";
	public static final String FRGN_YN       				= "FRGN_YN";
	public static final String STAY_QUAL       				= "STAY_QUAL";
	public static final String STAY_QUAL_START_DD       	= "STAY_QUAL_START_DD";
	public static final String STAY_QUAL_END_DD       		= "STAY_QUAL_END_DD";
	public static final String EMERG_CONT_NM       			= "EMERG_CONT_NM";
	public static final String EMERG_CONT_NO       			= "EMERG_CONT_NO";
	public static final String EMERG_CONT_REL       		= "EMERG_CONT_REL";
	public static final String PROT_EQUIP_MNGT       		= "PROT_EQUIP_MNGT";
	public static final String MPW_TYP       				= "MPW_TYP";
	public static final String PIN_IMG_DATA       			= "PIN_IMG_DATA";
	public static final String UNIT_COST_WAGE       		= "UNIT_COST_WAGE";
	public static final String REG_ID       				= "REG_ID";
	public static final String REG_DT       				= "REG_DT";
	public static final String REG_NM       				= "REG_NM";
	public static final String UPDT_ID       				= "UPDT_ID";
	public static final String UPDT_DT       				= "UPDT_DT";
	public static final String DEL_YN       				= "DEL_YN";
	public static final String DEL_YN_LBR       			= "DEL_YN_LBR";


	//입퇴장시간조회 LIST
	public static final String MPW_CHK_DD					= "MPW_CHK_DD";
	public static final String CHK_IN_DD					= "CHK_IN_DD";
	public static final String CHK_IN_TM					= "CHK_IN_TM";
	public static final String PHOTO_FILE					= "PHOTO_FILE";
	public static final String CHK_OUT_DD					= "CHK_OUT_DD";
	public static final String CHK_OUT_TM					= "CHK_OUT_TM";
	public static final String PHOTO_OUT_FILE				= "PHOTO_OUT_FILE";
	public static final String MNL_YN						= "MNL_YN";

	//프로젝트 조회
	public static final String PJT_NO 						= "PJT_NO";
	public static final String PJT_NM						= "PJT_NM";
	public static final String BASE_YEAR					= "BASE_YEAR";
	public static final String STEP							= "STEP";
	public static final String PJT_START_DD					= "PJT_START_DD";
	public static final String CLNT							= "CLNT";
	public static final String PJT_END_DD					= "PJT_END_DD";
	public static final String INTL_TYP					= "INTL_TYP";
	public static final String PM							= "PM";
	public static final String GC							= "GC";
	public static final String DG							= "DG";
	public static final String TOTAL_WE						= "TOTAL_WE";
	public static final String UNIT							= "UNIT";
	public static final String MAIN_LANG					= "MAIN_LANG";
	public static final String MAIN_LANG_NM					= "MAIN_LANG_NM";
	public static final String DSCP							= "DSCP";
	public static final String MAX_COM_LVL					= "MAX_COM_LVL";
	public static final String ACCESS_BATCH_UPDATE_YN		= "ACCESS_BATCH_UPDATE_YN";
	public static final String TYPE							= "TYPE";
	public static final String CNT							= "CNT";

    public static final String ENT_COD							= "ENT_COD";
    public static final String ENT_COD_NM						= "ENT_COD_NM";



	public static final CharSequence info[] = new CharSequence[] {"2000", "2001" };

}

