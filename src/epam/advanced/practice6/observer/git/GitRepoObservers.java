package epam.advanced.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GitRepoObservers {
    public static Repository newRepository(){
        return new Repository() {
            List<WebHook> webHooks = new ArrayList<>();
            List<Event> eventList = new ArrayList<>();
            @Override
            public void addWebHook(WebHook webHook) {
                webHooks.add(webHook);
            }

            @Override
            public Commit commit(String branch, String author, String[] changes) {
                Commit commit = new Commit(author, changes);
                List<Commit> commits = new ArrayList<>();
                commits.add(commit);
                Event event = new Event(Event.Type.COMMIT, branch, commits);
                boolean added = false;
                for(var hook : webHooks){
                    if(hook.type()==event.type() && Objects.equals(hook.branch(), event.branch())){
                        hook.onEvent(event);
                        if(!added){
                            added = true;
                            eventList.add(event);
                        }
                    }
                }
                return commit;
            }

            @Override
            public void merge(String sourceBranch, String targetBranch) {
                List<Event> events = new ArrayList<>();
                for(var event: eventList) {
                    if (event.branch().equals(sourceBranch)) {
                        events.add(event);
                    }
                }
                List<Commit> commits = new ArrayList<>();
                for(var event: events){
                    commits.addAll(event.commits());
                    eventList.remove(event);
                }

                Event event = new Event(Event.Type.MERGE, targetBranch, commits);
                eventList.add(event);
                for(var hook : webHooks){
                    if(hook.type()==event.type() && Objects.equals(hook.branch(), event.branch())){
                        hook.onEvent(event);
                    }
                }
            }
        };
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        return new WebHook() {
            final List<Event> events = new ArrayList<>();
            @Override
            public String branch() {
                return branchName;
            }

            @Override
            public Event.Type type() {
                return Event.Type.MERGE;
            }

            @Override
            public List<Event> caughtEvents() {
                return events;
            }

            @Override
            public void onEvent(Event event) {
                events.clear();
                events.add(event);
            }
        };
    }

    public static WebHook commitToBranchWebHook(String branchName){
        return new WebHook() {
            final List<Event> events = new ArrayList<>();
            @Override
            public String branch() {
                return branchName;
            }

            @Override
            public Event.Type type() {
                return Event.Type.COMMIT;
            }

            @Override
            public List<Event> caughtEvents() {
                return events;
            }

            @Override
            public void onEvent(Event event) {
                events.add(event);
            }
        };
    }


}
