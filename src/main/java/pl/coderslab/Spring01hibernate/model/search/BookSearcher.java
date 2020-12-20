package pl.coderslab.Spring01hibernate.model.search;

public class BookSearcher {

    private String titleQuery;
    private String descriptionQuery;
    private long authorId;

    public String getTitleQuery() {
        return titleQuery;
    }

    public void setTitleQuery(String titleQuery) {
        this.titleQuery = titleQuery;
    }

    public String getDescriptionQuery() {
        return descriptionQuery;
    }

    public void setDescriptionQuery(String descriptionQuery) {
        this.descriptionQuery = descriptionQuery;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
