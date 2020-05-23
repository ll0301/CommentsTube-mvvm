package com.jroomstudio.smartbookmarkeditor.data.bookmark.source.remote;

import androidx.annotation.NonNull;

import com.jroomstudio.smartbookmarkeditor.data.bookmark.Bookmark;
import com.jroomstudio.smartbookmarkeditor.data.category.Category;

import java.util.List;

public interface BookmarksRemoteDataSource {

    interface RefreshTokenCallback{
        void onRefreshTokenCallback();
        void refreshTokenFailed();
    }

    interface LoadBookmarksCallback{
        void onBookmarksLoaded(List<Bookmark> bookmarks);
        void onDataNotAvailable();
    }

    interface GetBookmarkCallback {
        void onBookmarkLoaded(Bookmark bookmark);
        void onDataNotAvailable();
    }

    interface UpdateCallback{
        void onCompletedUpdate();
        void onFailedUpdate();
    }

    interface LoadCategoriesCallback{
        void onCategoriesLoaded(List<Category> categories);
        void onDataNotAvailable();
    }

    // 토큰만료시 재발급
    void refreshToken(@NonNull RefreshTokenCallback callback);

    // 입력된 카테고리인 bookmark 를 전부 가져온다.
    void getBookmarks(@NonNull String category,
                                   @NonNull LoadBookmarksCallback callback);
    // 특정 북마크를 가져온다.
    void getBookmark(@NonNull Bookmark bookmark,
                     @NonNull GetBookmarkCallback callback);

    // 북마크를 저장하고 저장된 객체를 콜백으로 돌려받는다.
    void saveBookmark(@NonNull Bookmark bookmark);

    // 입력된 id의 Bookmark 객체를 찾아서 제거
    void deleteBookmark(@NonNull String id,@NonNull String category);

    // 입력된 카테고리의 bookmark 전부 제거
    void deleteAllInCategory(@NonNull String category);

    // 입력된 Bookmark 값 변경
    void updateBookmark(@NonNull Bookmark bookmark);

    // 입력된 리스트 값 변경
    void updateBookmarks(@NonNull List<Bookmark> bookmarks, @NonNull String category);

    /**
     *  카테고리
     **/
    void saveCategory(@NonNull Category category);

    void getAllCategories(@NonNull LoadCategoriesCallback callback);

    void selectedCategory(@NonNull String category, @NonNull UpdateCallback callback);

}
