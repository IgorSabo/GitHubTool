package rs.git.api.connector.core;

import rs.git.api.connector.responses.ApiRepoResponse;
import rs.git.api.connector.loaders.DisplayConfigLoader;

import java.util.List;

/**
 * Created by Gile on 5/8/2017.
 */
public class StringCreator {

    public static final String DOUBLE_TAB_INDENT="\t\t";
    public static final String TRIPLE_TAB_INDENT="\t\t\t";


    public static String createCustomResultString(List<ApiRepoResponse> listResponses, boolean useCustomProfile){
        StringBuilder sb = new StringBuilder();
        DisplayConfigLoader config = DisplayConfigLoader.getInstance();

        for(ApiRepoResponse response : listResponses){


            if(!useCustomProfile || config.isShowId()){
                sb.append(DOUBLE_TAB_INDENT+"id = "+response.getId()).append("\n");
            }

            if(!useCustomProfile || config.isShowName()){
                sb.append(DOUBLE_TAB_INDENT+"name = "+response.getName()).append("\n");
            }

            if(!useCustomProfile || config.isShowFullName()){
                sb.append(DOUBLE_TAB_INDENT+"full_name = "+response.getFull_name()).append("\n");
            }

            if(!useCustomProfile || config.isShowIsPrivate()){
                sb.append(DOUBLE_TAB_INDENT+"private = "+response.isPrivate()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerLogin()){
                sb.append(TRIPLE_TAB_INDENT+"owner_login = "+response.getOwner().getLogin()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerId()){
                sb.append(TRIPLE_TAB_INDENT+"owner_id = "+response.getOwner().getId()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerAvatarUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_avatar_url = "+response.getOwner().getAvatar_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerGravatarId()){
                sb.append(TRIPLE_TAB_INDENT+"owner_gravatar_id = "+response.getOwner().getGravatar_id()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_url = "+response.getOwner().getUrl()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerHtmlUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_html_url = "+response.getOwner().getHtml_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerFollowersUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_followers_url = "+response.getOwner().getFollowers_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerFollowingUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_following_url = "+response.getOwner().getFollowing_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerGistsUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_gists_url = "+response.getOwner().getGists_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerStarredUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_starred_url = "+response.getOwner().getStarred_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerSubscriptionsUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_subscriptions_url = "+response.getOwner().getSubscriptions_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerOrganizationsUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_organizations_url = "+response.getOwner().getOrganizations_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerReposUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_repos_url = "+response.getOwner().getRepos_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerEventsUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_events_url = "+response.getOwner().getEvents_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerReceivedEventsUrl()){
                sb.append(TRIPLE_TAB_INDENT+"owner_received_events_url = "+response.getOwner().getReceived_events_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerType()){
                sb.append(TRIPLE_TAB_INDENT+"owner_type = "+response.getOwner().getType()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerType()){
                sb.append(TRIPLE_TAB_INDENT+"owner_type = "+response.getOwner().getType()).append("\n");
            }

            if(!useCustomProfile || config.isShowOwnerIsSiteAdmin()){
                sb.append(TRIPLE_TAB_INDENT+"owner_site_admin = "+response.getOwner().isSite_admin()).append("\n");
            }

            if(!useCustomProfile || config.isShowHtmlUrl()){
                sb.append(DOUBLE_TAB_INDENT+"html_url = "+response.getHtml_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowDescription()){
                sb.append(DOUBLE_TAB_INDENT+"description = "+response.getDescription()).append("\n");
            }

            if(!useCustomProfile || config.isShowIsFork()){
                sb.append(DOUBLE_TAB_INDENT+"fork = "+response.isFork()).append("\n");
            }

            if(!useCustomProfile || config.isShowUrl()){
                sb.append(DOUBLE_TAB_INDENT+"url = "+response.getUrl()).append("\n");
            }

            if(!useCustomProfile || config.isShowForksUrl()){
                sb.append(DOUBLE_TAB_INDENT+"forks_url = "+response.getForks_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowKeysUrl()){
                sb.append(DOUBLE_TAB_INDENT+"keys_url = "+response.getKeys_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowKeysUrl()){
                sb.append(DOUBLE_TAB_INDENT+"keys_url = "+response.getKeys_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCollaboratorsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"collaborators_url = "+response.getCollaborators_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowTeamsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"teams_url = "+response.getTeams_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowHooksUrl()){
                sb.append(DOUBLE_TAB_INDENT+"hooks_url = "+response.getHooks_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowIssueEventsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"issue_events_url = "+response.getIssue_events_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowEventsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"events_url = "+response.getEvents_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowAssigneesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"assignees_url = "+response.getAssignees_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowBranchesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"branches_url = "+response.getBranches_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowTagsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"tags_url = "+response.getTags_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowBlobsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"blobs_url = "+response.getBlobs_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowGitTagsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"git_tags_url = "+response.getGit_tags_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowGitRefsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"git_refs_url = "+response.getGit_refs_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowTreesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"trees_url = "+response.getTrees_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowStatusesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"statuses_url = "+response.getStatuses_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowLanguagesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"languages_url = "+response.getLanguages_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowStargazersUrl()){
                sb.append(DOUBLE_TAB_INDENT+"stargazers_url = "+response.getStargazers_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowContributorsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"contributors_url = "+response.getContributors_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowSubscribersUrl()){
                sb.append(DOUBLE_TAB_INDENT+"subscribers_url = "+response.getSubscribers_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowSubscriptionUrl()){
                sb.append(DOUBLE_TAB_INDENT+"subscription_url = "+response.getSubscription_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCommitsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"commits_url = "+response.getCommits_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowGitCommitsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"git_commits_url = "+response.getGit_commits_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCommentsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"comments_url = "+response.getComments_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowIssueCommentUrl()){
                sb.append(DOUBLE_TAB_INDENT+"issue_comment_url = "+response.getIssue_comment_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowContentsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"contents_url = "+response.getContents_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCompareUrl()){
                sb.append(DOUBLE_TAB_INDENT+"compare_url = "+response.getCompare_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowMergesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"merges_url = "+response.getMerges_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowArchiveUrl()){
                sb.append(DOUBLE_TAB_INDENT+"archive_url = "+response.getArchive_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowDownloadsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"downloads_url = "+response.getDownloads_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowIssuesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"issues_url = "+response.getIssues_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowPullsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"pulls_url = "+response.getPulls_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowMilestonesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"milestones_url = "+response.getMilestones_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowNotificationsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"notifications_url = "+response.getNotifications_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowLabelsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"labels_url = "+response.getLabels_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowReleasesUrl()){
                sb.append(DOUBLE_TAB_INDENT+"releases_url = "+response.getReleases_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowDeploymentsUrl()){
                sb.append(DOUBLE_TAB_INDENT+"deployments_url = "+response.getDeployments_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCreatedAt()){
                sb.append(DOUBLE_TAB_INDENT+"created_at = "+response.getCreated_at()).append("\n");
            }

            if(!useCustomProfile || config.isShowUpdatedAt()){
                sb.append(DOUBLE_TAB_INDENT+"updated_at = "+response.getUpdated_at()).append("\n");
            }

            if(!useCustomProfile || config.isShowPushedAt()){
                sb.append(DOUBLE_TAB_INDENT+"pushed_at = "+response.getPushed_at()).append("\n");
            }

            if(!useCustomProfile || config.isShowGitUrl()){
                sb.append(DOUBLE_TAB_INDENT+"git_url = "+response.getGit_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowSshUrl()){
                sb.append(DOUBLE_TAB_INDENT+"ssh_url = "+response.getSsh_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowCloneUrl()){
                sb.append(DOUBLE_TAB_INDENT+"clone_url = "+response.getClone_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowSvnUrl()){
                sb.append(DOUBLE_TAB_INDENT+"svn_url = "+response.getSvn_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowHomepage()){
                sb.append(DOUBLE_TAB_INDENT+"homepage = "+response.getHomepage()).append("\n");
            }

            if(!useCustomProfile || config.isShowSize()){
                sb.append(DOUBLE_TAB_INDENT+"size = "+response.getSize()).append("\n");
            }

            if(!useCustomProfile || config.isShowSize()){
                sb.append(DOUBLE_TAB_INDENT+"size = "+response.getSize()).append("\n");
            }

            if(!useCustomProfile || config.isShowStargazersCount()){
                sb.append(DOUBLE_TAB_INDENT+"stargazers_count = "+response.getStargazers_count()).append("\n");
            }

            if(!useCustomProfile || config.isShowWatchersCount()){
                sb.append(DOUBLE_TAB_INDENT+"watchers_count = "+response.getWatchers_count()).append("\n");
            }

            if(!useCustomProfile || config.isShowLanguage()){
                sb.append(DOUBLE_TAB_INDENT+"language = "+response.getLanguage()).append("\n");
            }

            if(!useCustomProfile || config.isShowHasIssues()){
                sb.append(DOUBLE_TAB_INDENT+"has_issues = "+response.isHas_issues()).append("\n");
            }

            if(!useCustomProfile || config.isShowHasProjects()){
                sb.append(DOUBLE_TAB_INDENT+"has_projects = "+response.isHas_projects()).append("\n");
            }

            if(!useCustomProfile || config.isShowHasDownloads()){
                sb.append(DOUBLE_TAB_INDENT+"has_downloads = "+response.isHas_downloads()).append("\n");
            }

            if(!useCustomProfile || config.isShowHasWiki()){
                sb.append(DOUBLE_TAB_INDENT+"has_wiki = "+response.isHas_wiki()).append("\n");
            }

            if(!useCustomProfile || config.isShowHasPages()){
                sb.append(DOUBLE_TAB_INDENT+"has_pages = "+response.isHas_pages()).append("\n");
            }

            if(!useCustomProfile || config.isShowForksCount()){
                sb.append(DOUBLE_TAB_INDENT+"forks_count = "+response.getForks_count()).append("\n");
            }

            if(!useCustomProfile || config.isShowMirrorUrl()){
                sb.append(DOUBLE_TAB_INDENT+"mirror_url = "+response.getMirror_url()).append("\n");
            }

            if(!useCustomProfile || config.isShowOpenIssuesCount()){
                sb.append(DOUBLE_TAB_INDENT+"open_issues_count = "+response.getOpen_issues_count()).append("\n");
            }

            if(!useCustomProfile || config.isShowForks()){
                sb.append(DOUBLE_TAB_INDENT+"forks = "+response.getForks()).append("\n");
            }

            if(!useCustomProfile || config.isShowOpenIssues()){
                sb.append(DOUBLE_TAB_INDENT+"open_issues = "+response.getOpen_issues()).append("\n");
            }

            if(!useCustomProfile || config.isShowWatchers()){
                sb.append(DOUBLE_TAB_INDENT+"watchers = "+response.getWatchers()).append("\n");
            }

            if(!useCustomProfile || config.isShowDefaultBranch()){
                sb.append(DOUBLE_TAB_INDENT+"default_branch = "+response.getDefault_branch()).append("\n");
            }

            if(!useCustomProfile || config.isShowScore()){
                sb.append(DOUBLE_TAB_INDENT+"score = "+response.getScore()).append("\n");
            }

            sb.append("\n").append("\n");
        }

        return sb.toString();
    }

}
