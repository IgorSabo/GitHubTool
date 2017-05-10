package rs.git.api.connector.loaders;

import rs.git.api.connector.GitHubApiConnector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Gile on 5/7/2017.
 */
public class DisplayConfigLoader {

    private static Properties properties;

    private DisplayConfigLoader(){
        init();
    }

    private static DisplayConfigLoader instance;

    public static synchronized DisplayConfigLoader getInstance(){

        if(instance == null)
            instance = new DisplayConfigLoader();

        return instance;
    }


    private  boolean showId;
    private  boolean showName;
    private  boolean showFullName;

    private  boolean showIsPrivate;
    private  boolean showHtmlUrl;
    private  boolean showDescription;
    private  boolean showIsFork;
    private  boolean showUrl;
    private  boolean showForksUrl;
    private  boolean showKeysUrl;
    private  boolean showCollaboratorsUrl;
    private  boolean showTeamsUrl;
    private  boolean showHooksUrl;
    private  boolean showIssueEventsUrl;
    private  boolean showEventsUrl;
    private  boolean showAssigneesUrl;
    private  boolean showBranchesUrl;
    private  boolean showTagsUrl;
    private  boolean showBlobsUrl;
    private  boolean showGitTagsUrl;
    private  boolean showGitRefsUrl;
    private  boolean showTreesUrl;
    private  boolean showStatusesUrl;
    private  boolean showLanguagesUrl;
    private  boolean showStargazersUrl;
    private  boolean showContributorsUrl;
    private  boolean showSubscribersUrl;
    private  boolean showSubscriptionUrl;
    private  boolean showCommitsUrl;
    private  boolean showGitCommitsUrl;
    private  boolean showCommentsUrl;
    private  boolean showIssueCommentUrl;
    private  boolean showContentsUrl;
    private  boolean showCompareUrl;
    private  boolean showMergesUrl;
    private  boolean showArchiveUrl;
    private  boolean showDownloadsUrl;
    private  boolean showIssuesUrl;
    private  boolean showPullsUrl;
    private  boolean showMilestonesUrl;
    private  boolean showNotificationsUrl;
    private  boolean showLabelsUrl;
    private  boolean showReleasesUrl;
    private  boolean showDeploymentsUrl;
    private  boolean showCreatedAt;
    private  boolean showUpdatedAt;
    private  boolean showPushedAt;
    private  boolean showGitUrl;
    private  boolean showSshUrl;
    private  boolean showCloneUrl;
    private  boolean showSvnUrl;
    private  boolean showHomepage;
    private  boolean showSize;
    private  boolean showStargazersCount;
    private  boolean showWatchersCount;
    private  boolean showLanguage;
    private  boolean showHasIssues;
    private  boolean showHasProjects;
    private  boolean showHasDownloads;
    private  boolean showHasWiki;
    private  boolean showHasPages;
    private  boolean showForksCount;
    private  boolean showMirrorUrl;
    private  boolean showOpenIssuesCount;
    private  boolean showForks;
    private  boolean showOpenIssues;
    private  boolean showWatchers;
    private  boolean showDefaultBranch;
    private  boolean showScore;


    //owner
    private  boolean showOwnerLogin;
    private  boolean showOwnerId;
    private  boolean showOwnerAvatarUrl;
    private  boolean showOwnerGravatarId;
    private  boolean showOwnerUrl;
    private  boolean showOwnerHtmlUrl;
    private  boolean showOwnerFollowersUrl;
    private  boolean showOwnerFollowingUrl;
    private  boolean showOwnerGistsUrl;
    private  boolean showOwnerStarredUrl;
    private  boolean showOwnerSubscriptionsUrl;
    private  boolean showOwnerOrganizationsUrl;
    private  boolean showOwnerReposUrl;
    private  boolean showOwnerEventsUrl;
    private  boolean showOwnerReceivedEventsUrl;
    private  boolean showOwnerType;
    private  boolean showOwnerIsSiteAdmin;


    public static Properties getProperties() {
        return properties;
    }

    public boolean isShowId() {
        return showId;
    }

    public boolean isShowName() {
        return showName;
    }

    public boolean isShowFullName() {
        return showFullName;
    }

    public boolean isShowIsPrivate() {
        return showIsPrivate;
    }

    public boolean isShowHtmlUrl() {
        return showHtmlUrl;
    }

    public boolean isShowDescription() {
        return showDescription;
    }

    public boolean isShowIsFork() {
        return showIsFork;
    }

    public boolean isShowUrl() {
        return showUrl;
    }

    public boolean isShowForksUrl() {
        return showForksUrl;
    }

    public boolean isShowKeysUrl() {
        return showKeysUrl;
    }

    public boolean isShowCollaboratorsUrl() {
        return showCollaboratorsUrl;
    }

    public boolean isShowTeamsUrl() {
        return showTeamsUrl;
    }

    public boolean isShowHooksUrl() {
        return showHooksUrl;
    }

    public boolean isShowIssueEventsUrl() {
        return showIssueEventsUrl;
    }

    public boolean isShowEventsUrl() {
        return showEventsUrl;
    }

    public boolean isShowAssigneesUrl() {
        return showAssigneesUrl;
    }

    public boolean isShowBranchesUrl() {
        return showBranchesUrl;
    }

    public boolean isShowTagsUrl() {
        return showTagsUrl;
    }

    public boolean isShowBlobsUrl() {
        return showBlobsUrl;
    }

    public boolean isShowGitTagsUrl() {
        return showGitTagsUrl;
    }

    public boolean isShowGitRefsUrl() {
        return showGitRefsUrl;
    }

    public boolean isShowTreesUrl() {
        return showTreesUrl;
    }

    public boolean isShowStatusesUrl() {
        return showStatusesUrl;
    }

    public boolean isShowLanguagesUrl() {
        return showLanguagesUrl;
    }

    public boolean isShowStargazersUrl() {
        return showStargazersUrl;
    }

    public boolean isShowContributorsUrl() {
        return showContributorsUrl;
    }

    public boolean isShowSubscribersUrl() {
        return showSubscribersUrl;
    }

    public boolean isShowSubscriptionUrl() {
        return showSubscriptionUrl;
    }

    public boolean isShowCommitsUrl() {
        return showCommitsUrl;
    }

    public boolean isShowGitCommitsUrl() {
        return showGitCommitsUrl;
    }

    public boolean isShowCommentsUrl() {
        return showCommentsUrl;
    }

    public boolean isShowIssueCommentUrl() {
        return showIssueCommentUrl;
    }

    public boolean isShowContentsUrl() {
        return showContentsUrl;
    }

    public boolean isShowCompareUrl() {
        return showCompareUrl;
    }

    public boolean isShowMergesUrl() {
        return showMergesUrl;
    }

    public boolean isShowArchiveUrl() {
        return showArchiveUrl;
    }

    public boolean isShowDownloadsUrl() {
        return showDownloadsUrl;
    }

    public boolean isShowIssuesUrl() {
        return showIssuesUrl;
    }

    public boolean isShowPullsUrl() {
        return showPullsUrl;
    }

    public boolean isShowMilestonesUrl() {
        return showMilestonesUrl;
    }

    public boolean isShowNotificationsUrl() {
        return showNotificationsUrl;
    }

    public boolean isShowLabelsUrl() {
        return showLabelsUrl;
    }

    public boolean isShowReleasesUrl() {
        return showReleasesUrl;
    }

    public boolean isShowDeploymentsUrl() {
        return showDeploymentsUrl;
    }

    public boolean isShowCreatedAt() {
        return showCreatedAt;
    }

    public boolean isShowUpdatedAt() {
        return showUpdatedAt;
    }

    public boolean isShowPushedAt() {
        return showPushedAt;
    }

    public boolean isShowGitUrl() {
        return showGitUrl;
    }

    public boolean isShowSshUrl() {
        return showSshUrl;
    }

    public boolean isShowCloneUrl() {
        return showCloneUrl;
    }

    public boolean isShowSvnUrl() {
        return showSvnUrl;
    }

    public boolean isShowHomepage() {
        return showHomepage;
    }

    public boolean isShowSize() {
        return showSize;
    }

    public boolean isShowStargazersCount() {
        return showStargazersCount;
    }

    public boolean isShowWatchersCount() {
        return showWatchersCount;
    }

    public boolean isShowLanguage() {
        return showLanguage;
    }

    public boolean isShowHasIssues() {
        return showHasIssues;
    }

    public boolean isShowHasProjects() {
        return showHasProjects;
    }

    public boolean isShowHasDownloads() {
        return showHasDownloads;
    }

    public boolean isShowHasWiki() {
        return showHasWiki;
    }

    public boolean isShowHasPages() {
        return showHasPages;
    }

    public boolean isShowForksCount() {
        return showForksCount;
    }

    public boolean isShowMirrorUrl() {
        return showMirrorUrl;
    }

    public boolean isShowOpenIssuesCount() {
        return showOpenIssuesCount;
    }

    public boolean isShowForks() {
        return showForks;
    }

    public boolean isShowOpenIssues() {
        return showOpenIssues;
    }

    public boolean isShowWatchers() {
        return showWatchers;
    }

    public boolean isShowDefaultBranch() {
        return showDefaultBranch;
    }

    public boolean isShowScore() {
        return showScore;
    }

    public boolean isShowOwnerLogin() {
        return showOwnerLogin;
    }

    public boolean isShowOwnerId() {
        return showOwnerId;
    }

    public boolean isShowOwnerAvatarUrl() {
        return showOwnerAvatarUrl;
    }

    public boolean isShowOwnerGravatarId() {
        return showOwnerGravatarId;
    }

    public boolean isShowOwnerUrl() {
        return showOwnerUrl;
    }

    public boolean isShowOwnerHtmlUrl() {
        return showOwnerHtmlUrl;
    }

    public boolean isShowOwnerFollowersUrl() {
        return showOwnerFollowersUrl;
    }

    public boolean isShowOwnerFollowingUrl() {
        return showOwnerFollowingUrl;
    }

    public boolean isShowOwnerGistsUrl() {
        return showOwnerGistsUrl;
    }

    public boolean isShowOwnerStarredUrl() {
        return showOwnerStarredUrl;
    }

    public boolean isShowOwnerSubscriptionsUrl() {
        return showOwnerSubscriptionsUrl;
    }

    public boolean isShowOwnerOrganizationsUrl() {
        return showOwnerOrganizationsUrl;
    }

    public boolean isShowOwnerReposUrl() {
        return showOwnerReposUrl;
    }

    public boolean isShowOwnerEventsUrl() {
        return showOwnerEventsUrl;
    }

    public boolean isShowOwnerReceivedEventsUrl() {
        return showOwnerReceivedEventsUrl;
    }

    public boolean isShowOwnerType() {
        return showOwnerType;
    }

    public boolean isShowOwnerIsSiteAdmin() {
        return showOwnerIsSiteAdmin;
    }

    private void init() {
        properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config/displayParametersConfig.properties");
            //input = GitHubApiConnector.class.getClassLoader().getResourceAsStream("displayParametersConfig.properties");
            properties.load(input);

            showId = Boolean.parseBoolean(properties.getProperty("id"));
            showName = Boolean.parseBoolean(properties.getProperty("name"));
            showFullName = Boolean.parseBoolean(properties.getProperty("full_name"));
            showIsPrivate = Boolean.parseBoolean(properties.getProperty("private"));
            showHtmlUrl = Boolean.parseBoolean(properties.getProperty("html_url"));
            showDescription = Boolean.parseBoolean(properties.getProperty("description"));
            showIsFork = Boolean.parseBoolean(properties.getProperty("fork"));
            showUrl = Boolean.parseBoolean(properties.getProperty("url"));
            showForksUrl = Boolean.parseBoolean(properties.getProperty("forks_url"));
            showKeysUrl = Boolean.parseBoolean(properties.getProperty("keys_url"));
            showCollaboratorsUrl = Boolean.parseBoolean(properties.getProperty("collaborators_url"));
            showTeamsUrl = Boolean.parseBoolean(properties.getProperty("teams_url"));
            showHooksUrl = Boolean.parseBoolean(properties.getProperty("hooks_url"));
            showIssueEventsUrl = Boolean.parseBoolean(properties.getProperty("issue_events_url"));
            showEventsUrl = Boolean.parseBoolean(properties.getProperty("events_url"));
            showAssigneesUrl = Boolean.parseBoolean(properties.getProperty("assignees_url"));
            showBranchesUrl = Boolean.parseBoolean(properties.getProperty("branches_url"));
            showTagsUrl = Boolean.parseBoolean(properties.getProperty("tags_url"));
            showBlobsUrl = Boolean.parseBoolean(properties.getProperty("blobs_url"));
            showGitTagsUrl = Boolean.parseBoolean(properties.getProperty("git_tags_url"));
            showGitRefsUrl = Boolean.parseBoolean(properties.getProperty("git_refs_url"));
            showTreesUrl = Boolean.parseBoolean(properties.getProperty("trees_url"));
            showStatusesUrl = Boolean.parseBoolean(properties.getProperty("statuses_url"));
            showLanguagesUrl = Boolean.parseBoolean(properties.getProperty("languages_url"));
            showStargazersUrl = Boolean.parseBoolean(properties.getProperty("stargazers_url"));
            showContributorsUrl = Boolean.parseBoolean(properties.getProperty("contributors_url"));
            showSubscribersUrl = Boolean.parseBoolean(properties.getProperty("subscribers_url"));
            showSubscriptionUrl = Boolean.parseBoolean(properties.getProperty("subscription_url"));
            showCommitsUrl = Boolean.parseBoolean(properties.getProperty("commits_url"));
            showGitCommitsUrl = Boolean.parseBoolean(properties.getProperty("git_commits_url"));
            showCommentsUrl = Boolean.parseBoolean(properties.getProperty("comments_url"));
            showIssueCommentUrl = Boolean.parseBoolean(properties.getProperty("issue_comment_url"));
            showContentsUrl = Boolean.parseBoolean(properties.getProperty("contents_url"));
            showCompareUrl = Boolean.parseBoolean(properties.getProperty("compare_url"));
            showMergesUrl = Boolean.parseBoolean(properties.getProperty("merges_url"));
            showArchiveUrl = Boolean.parseBoolean(properties.getProperty("archive_url"));
            showDownloadsUrl = Boolean.parseBoolean(properties.getProperty("downloads_url"));
            showIssuesUrl = Boolean.parseBoolean(properties.getProperty("issues_url"));
            showPullsUrl = Boolean.parseBoolean(properties.getProperty("pulls_url"));
            showMilestonesUrl = Boolean.parseBoolean(properties.getProperty("milestones_url"));
            showNotificationsUrl = Boolean.parseBoolean(properties.getProperty("notifications_url"));
            showLabelsUrl = Boolean.parseBoolean(properties.getProperty("labels_url"));
            showReleasesUrl = Boolean.parseBoolean(properties.getProperty("releases_url"));
            showDeploymentsUrl = Boolean.parseBoolean(properties.getProperty("deployments_url"));
            showCreatedAt = Boolean.parseBoolean(properties.getProperty("created_at"));
            showUpdatedAt = Boolean.parseBoolean(properties.getProperty("updated_at"));
            showPushedAt = Boolean.parseBoolean(properties.getProperty("pushed_at"));
            showGitUrl = Boolean.parseBoolean(properties.getProperty("git_url"));
            showSshUrl = Boolean.parseBoolean(properties.getProperty("ssh_url"));
            showCloneUrl = Boolean.parseBoolean(properties.getProperty("clone_url"));
            showSvnUrl = Boolean.parseBoolean(properties.getProperty("svn_url"));
            showHomepage = Boolean.parseBoolean(properties.getProperty("homepage"));
            showSize = Boolean.parseBoolean(properties.getProperty("size"));
            showStargazersCount = Boolean.parseBoolean(properties.getProperty("stargazers_count"));
            showWatchersCount = Boolean.parseBoolean(properties.getProperty("watchers_count"));
            showLanguage = Boolean.parseBoolean(properties.getProperty("language"));
            showHasIssues = Boolean.parseBoolean(properties.getProperty("has_issues"));
            showHasProjects = Boolean.parseBoolean(properties.getProperty("has_projects"));
            showHasDownloads = Boolean.parseBoolean(properties.getProperty("has_downloads"));
            showHasWiki = Boolean.parseBoolean(properties.getProperty("has_wiki"));
            showHasPages = Boolean.parseBoolean(properties.getProperty("has_pages"));
            showForksCount = Boolean.parseBoolean(properties.getProperty("forks_count"));
            showMirrorUrl = Boolean.parseBoolean(properties.getProperty("mirror_url"));
            showOpenIssuesCount = Boolean.parseBoolean(properties.getProperty("open_issues_count"));
            showForks = Boolean.parseBoolean(properties.getProperty("forks"));
            showOpenIssues = Boolean.parseBoolean(properties.getProperty("open_issues"));
            showWatchers = Boolean.parseBoolean(properties.getProperty("watchers"));
            showDefaultBranch = Boolean.parseBoolean(properties.getProperty("default_branch"));
            showScore = Boolean.parseBoolean(properties.getProperty("score"));

            showOwnerLogin = Boolean.parseBoolean(properties.getProperty("owner_login"));
            showOwnerId = Boolean.parseBoolean(properties.getProperty("owner_id"));
            showOwnerAvatarUrl = Boolean.parseBoolean(properties.getProperty("owner_avatar_url"));
            showOwnerGravatarId = Boolean.parseBoolean(properties.getProperty("owner_gravatar_id"));
            showOwnerUrl = Boolean.parseBoolean(properties.getProperty("owner_url"));
            showOwnerHtmlUrl = Boolean.parseBoolean(properties.getProperty("owner_html_url"));
            showOwnerFollowersUrl = Boolean.parseBoolean(properties.getProperty("owner_followers_url"));
            showOwnerFollowingUrl = Boolean.parseBoolean(properties.getProperty("owner_following_url"));
            showOwnerGistsUrl = Boolean.parseBoolean(properties.getProperty("owner_gists_url"));
            showOwnerStarredUrl = Boolean.parseBoolean(properties.getProperty("owner_starred_url"));
            showOwnerSubscriptionsUrl = Boolean.parseBoolean(properties.getProperty("owner_subscriptions_url"));
            showOwnerOrganizationsUrl = Boolean.parseBoolean(properties.getProperty("owner_organizations_url"));
            showOwnerReposUrl = Boolean.parseBoolean(properties.getProperty("owner_repos_url"));
            showOwnerEventsUrl = Boolean.parseBoolean(properties.getProperty("owner_events_url"));
            showOwnerReceivedEventsUrl = Boolean.parseBoolean(properties.getProperty("owner_received_events_url"));
            showOwnerType = Boolean.parseBoolean(properties.getProperty("owner_type"));
            showOwnerIsSiteAdmin = Boolean.parseBoolean(properties.getProperty("owner_site_admin"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void reinitializeConfig(){
        init();
    }
}
