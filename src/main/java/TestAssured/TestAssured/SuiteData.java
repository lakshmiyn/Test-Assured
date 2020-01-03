package TestAssured.TestAssured;




import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.UUID;


/*
 * This class holds the configuration data that is essentially hard coded for use across many tests.
 * Some of this data may be environment specific. (develop, release, master, etc.), other values may just be hard coded
 * if they don't need to change across environments.
 *
 * The environments share the same names as their git branches.
 */
public class SuiteData {
    private static SuiteData instance = null;
    // Property file loaded based on environment system parameter,
    //
    // getters are below for each property, we don't want the individual test methods to need to know that there are
    // properties files backing the environment specific configurations.
    Properties properties = new Properties();
    // This value is loaded from system properties so that it can be managed between environments through Kubernetes
    //
    // Key value used to load files (properties, json, etc) in an environment specific way this value should not be
    // used outside of this class.  If you find a need to use it in a test class then you are probably doing something
    // wrong.
    //
    // The default value is "develop" so that running the tests locally will hit all of the dev server URLs with the dev
    // server configurations.  If you are doing new development, and want some of the tests to go against localhost
    // then just temporarily change the URLs and any other needed configuration in dev.properties.
    private String environment = "config";

    private static final String instanceRunUUID = java.util.UUID.randomUUID().toString();


    protected SuiteData() throws IOException {
        load();
    }

    public static SuiteData getData() throws IOException {
        if (instance == null) {
            instance = new SuiteData();
        }
        return instance;
    }

   @Deprecated
    public void load() throws IOException {
   
    	try {
        String serverEnvironment = System.getProperty("server.environment");
        if (serverEnvironment != null) {
            this.environment = serverEnvironment;
        }

        String filename = String.format("config.properties", this.environment);
       // System.out.println("Filename::........"+filename);
        //throw new IOException("Cannot find resource: " + filename);
        //System.out.println(System.getProperty("user.dir")+"/test-api-automation-develop/src/test/resources/env/"+filename););
        FileInputStream is=new FileInputStream("/Users/niyarabarla/eclipse-workspace/TestAssured/src/main/java/TestAssured/TestAssured/config.properties");
       System.out.println("is..."+is);
        if (is == null) {
		    throw new IOException("Cannot find resource: " + filename);
		}
        System.out.println("/************ PROPERTIES **********");
        properties.load(is);

		System.out.println("/************ PROPERTIES **********");
		System.out.println("USING: " + this.environment + ".properties");
		Enumeration keys = properties.keys();
		while (keys.hasMoreElements()) {
		    String key = (String) keys.nextElement();
		    String value = (String) properties.get(key);
		    System.out.println(key + ": " + value);
		}
		System.out.println("/**********************************"); 
         /* InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
		if (is == null) {
		    throw new IOException("Cannot find resource: " + filename);
		}
		properties.load(is);

		System.out.println("/************ PROPERTIES **********");
		System.out.println("USING: " + this.environment + ".properties");
		Enumeration keys = properties.keys();
		while (keys.hasMoreElements()) {
		    String key = (String) keys.nextElement();
		    String value = (String) properties.get(key);
		    System.out.println(key + ": " + value);
		}
		System.out.println("/**********************************"); 
      */
		System.out.println("/**********************************"); 
}
catch(Exception e)
{
	e.getStackTrace();
}

    }
//public static void main(String args[]) throws IOException
//{
//	System.out.println("Main Method...........");
//	System.out.println("ssssssssssssssss");
//	
//	//SuiteData.getData();
//	
	
//}
    public String getInstanceRunUUID() {
        return instanceRunUUID;
    }

    public String getAuthConfigBasicAuthUsername() {
        return properties.getProperty("auth.config.basic.auth.username");
    }

    public String getAuthConfigBasicAuthPassword() {
        return properties.getProperty("auth.config.basic.auth.password");
    }

    //These values are the same across all services and environments so we can just hard code them here.
    public String getUsername() {
        return "qa";
    }

    public String getPassword() {
        return "qa123!";
    }

    //The following are values we might want to hard code differently between environments (dev, rel, mas, etc.)
    public String getUcsBaseUri() {
        return properties.getProperty("ucs.baseUri");
    }

    public String getProvBaseUri() {
        return properties.getProperty("provisioning.baseUri");
    }

    public String getProvJwt() {
        return properties.getProperty("provJwt");
    }

    public String getPpmBaseUri() {
        return properties.getProperty("ppm.baseUri");
    }

    public String getPpmJwt(){
        return properties.getProperty("ppmJwt");
    }

    public String getVideoUuid(){
        return properties.getProperty("videoUuid");
    }
    public String getPKIOrgId() { return properties.getProperty("pkiOrgId");
    }

    public String getMarketingBaseUri() {
        return properties.getProperty("marketing.baseUri");
    }

    public String getSearchBaseUri() {
        return properties.getProperty("search.baseUri");
    }

    public String getOrgV2BaseUri() {
        return properties.getProperty("orgV2.baseUri");
    }

    public String getOrgId() {
        return properties.getProperty("orgId");
    }

    public String getLocOrgId() {
        return properties.getProperty("locOrgId");
    }

    public String getLbeUserId() {
        return properties.getProperty("lbe.userId");
    }

    public String getLearnerId() {
        return properties.getProperty("learnerId");
    }

    public String getLinkedContentId() {
        return properties.getProperty("linkedPathParameterContent");
    }

    public String getReportingBaseUri() {
        return properties.getProperty("reporting.baseUri");
    }

    public String getCommonServicesBaseUri() {
        return properties.getProperty("commonServices.baseUri");
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getDefaultSFTPFolder() {
        return properties.getProperty("sftp.folder");
    }

    public String getLpOrgId() {
        return properties.getProperty("lp.orgId");
    }

    public String getImportsOrgId() {
        return properties.getProperty("imports.orgId");
    }

    public String getExpLpOrgId() {
        return properties.getProperty("lpExpOrgId");
    }

    public String getExpLpJwt() {
        return properties.getProperty("lpExpJwt");
    }

    public String getSFTPImportsFolder() {
        return properties.getProperty("sftp.imports");
    }
    public String getOrgBaseUri() {
        return properties.getProperty("org.baseUri");
    }

    public String getComplianceAdaptorBaseUri() {
        return properties.getProperty("compliance.adapter.baseUri");
    }

    public String getTykPolicy() {
        return properties.getProperty("tyk.policy");
    }

    public String getDefaultSFTPConfigId() {
        return properties.getProperty("sftp.configId");
    }

    public String getDefaultSFTPUserName() {
        return properties.getProperty("sftp.username");
    }

    public String getDefaultSFTPUserPassword() {
        return properties.getProperty("sftp.user.password");
    }

    public String getDefaultSFTPHost() {
        return properties.getProperty("p.sftp.host");
    }

    public String getAuthConfigRequestUrl() {
        return properties.getProperty("auth.config.baseUri");
    }

    public String getTykBaseUrl() { return properties.getProperty("tyk.base.url"); }

    public String getXApiBaseUrl() { return properties.getProperty("xapi.base.url"); }

    public String getPracticeLabBaseUrl() {
        return properties.getProperty("practicelabs.base.url");
    }

    public String getJdbcUrl() {
        return properties.getProperty("jdbc.url");
    }

    public String getDbUsername() {
        return properties.getProperty("aws.db.username");
    }

    public String getDbPassword() {
        return properties.getProperty("aws.db.password");
    }

    public String getOrgAuth0ServiceProviderEndpoint() { return properties.getProperty("org.auth0.serviceProviderEndpoint"); }

    public String getPassportServiceProviderEndpoint() { return properties.getProperty("org.passport.serviceProviderEndpoint"); }

    public String getOrgAuth0EntityIdPrefix() {
        return properties.getProperty("org.auth0.entityIdPrefix");
    }

    public String getOrgPassportEntityIdPrefix() {
        return properties.getProperty("org.passport.entityIdPrefix");
    }

    public String getAuthConfigJdbcUrl() {
        return properties.getProperty("authConfig.jdbc.url");
    }

    public String getAuthConfigJdbcUsername() {
        return properties.getProperty("authConfig.jdbc.username");
    }

    public String getAuthConfigJdbcPassword() {
        return properties.getProperty("authConfig.jdbc.password");
    }

    public String getSchedulerBaseUri() {
        return properties.getProperty("report.scheduler.baseUri");
    }

    public String getEdgeServiceBaseUri() {
        return properties.getProperty("edgeService.baseUri");
    }


    public String getSchedulerUsername() {
        return properties.getProperty("schedulerUsername");
    }
    public String getSchedulerPassword() {
        return properties.getProperty("schedulerPassword");
    }


    public String getSftpAuditOrgId() {
        return properties.getProperty("sftp.audit.ogrId");
    }

    public String getContentDiscoveryBaseUrl() {
        return properties.getProperty("contentDiscovery.baseUri");
    }

    public String getUserInternalBaseUri() {
        return properties.getProperty("userInternal.baseUri");
    }

    public String getContentIntegrationInternalBaseUri() { return properties.getProperty("contentIntegrationInternal.baseUri"); }

    public String getContentAggregationBaseUri() { return properties.getProperty("contentAggregation.baseUri"); }

    public String getPMUUri() { return properties.getProperty("pmu.baseUri"); }

    public String getAggregationServiceBaseUrl() { return properties.getProperty("aggregationService.baseUri");
    }
    public String getProviderDiscoveryBaseUrl() { return properties.getProperty("providerDiscovery.baseUri");
    }
    public String getRusticiAdapterServiceBaseUrl() { return properties.getProperty("rusticiAdapterService.baseUri");
    }
    public String getInternalCommonServiceBaseUrl() {
        return properties.getProperty("internalCommonService.baseUri");
    }
    public String getContentImportServiceBaseUri(){ return properties.getProperty("contentImportService.baseUri");
    }
    public String getWintellectUserId() { return properties.getProperty("wintellectUserId");
    }
    public String getWintellectAssetId() {
        return properties.getProperty("wintellectAssetId");
    }
    public String getWintellectContentId() {
        return properties.getProperty("wintellectContentId");
    }
    public String getPracticeLabsAssetId() {
        return properties.getProperty("PracticeLabAssetId");
    }
    public String getTestPrepsAssetId() {
        return properties.getProperty("TestPrepAssetId");
    }

    public String getUserId() {
        return properties.getProperty("userId");
    }
    public String getContentId() {
        return properties.getProperty("contentId");
    }
    public String getRusticiProviderContext() {
        return properties.getProperty("rusticiProviderContext");
    }

    public String getPracticeLabsId() {
        return properties.getProperty("PracticeLabUUID");
    }
    public String getTestPrepsId() {
        return properties.getProperty("TestPrepUUID");
    }
    public String getLicensePoolId() {
        return properties.getProperty("licensePoolId");
    }

    public String getMultipleLicensePoolId() {
        return properties.getProperty("licensePoolIds");
    }

    public String getExternalUserId() {
        return properties.getProperty("externalUserId");
    }

    public String getJwtToken() {
        return properties.getProperty("jwtToken");
    }

    public String getOrgIdWhichIsNotHavingCmi5Connection() {
        return properties.getProperty("orgIdWithAuth0");
    }

    public String getSumTotalCaptionsSecret() {
        return properties.getProperty("sumtotal.captions.secret");
    }

    public String getSamlOrgId() { return properties.getProperty("saml.test.orgId"); }
    public String getSamlClientId() { return properties.getProperty("saml.test.clientid"); }
    public String getSamlRedirectUri() { return properties.getProperty("saml.redirectUri"); }
    public String getSamlIdpSignInUrl() { return properties.getProperty("saml.idp.signIn.url"); }
    public String getSamlIdpSignOutUrl() { return properties.getProperty("saml.idp.signOut.url"); }
    public String getSamlPostLoginXPath() { return properties.getProperty("saml.postlogin.xpath"); }


    public String getScormCloudUrl() { return properties.getProperty("scormCloudUrl"); }
    public String getScormCloudEmail() { return properties.getProperty("scormCloudEmail"); }
    public String getScormCloudPassword() { return properties.getProperty("scormCloudPassword"); }
    public String getCmi5CourseName() { return properties.getProperty("cmi5CourseName"); }
    public String getPostLaunchXPath() { return properties.getProperty("postLaunch.xpath"); }
    public String getPlayButtonXPath() { return properties.getProperty("playButtonXpath.xpath"); }
    public String getCmi5TitleXPath() { return properties.getProperty("cmi5Title.xpath"); }

    public String getAdminAssignmentPastCompleted() { return properties.getProperty("adminAssignmentPastCompleted"); }
    public String getLearnerAssignmentPastCompleted() { return properties.getProperty("learnerAssignmentPastCompleted"); }
    public String getAdminNoAssignment() { return properties.getProperty("adminNoAssignment"); }
    public String getAdminAssignmentPastExempted() { return properties.getProperty("adminAssignmentPastExempted"); }
    public String getAdminAssignmentPastEquivalency() { return properties.getProperty("adminAssignmentPastEquivalency"); }
    public String getLearnerAssignmentPastExempted() { return properties.getProperty("learnerAssignmentPastExempted"); }
    public String getAdminAssignmentNow() { return properties.getProperty("adminAssignmentNow"); }
    public String getLearner1UpcomingCompliance() { return properties.getProperty("learner1UpcomingCompliance"); }
    public String getLearnerAssignmentPastEquivalency() { return properties.getProperty("learnerAssignmentPastEquivalency"); }
    public String getLearner3Overdue() { return properties.getProperty("learner3Overdue"); }
    public String getLearnerAssignmentNow() { return properties.getProperty("learnerAssignmentNow"); }
    public String getLearnerNoAssignment() { return properties.getProperty("learnerNoAssignment"); }
    public String getAdmin4Overdue() { return properties.getProperty("admin4Overdue"); }
    public String getAdmin2UpcomingCompliance() { return properties.getProperty("admin2UpcomingCompliance"); }
    public String getRandomOrgId(){return properties.getProperty("nonExisting.orgId");}

    public String getDefaultWorkdayFolderPath(){return properties.getProperty("deafultWorkdayFolderPath");}






}
