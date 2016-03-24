package alexeysachkov.androidsimple;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import java.util.Arrays;

public class CategoriesContentProvider extends ContentProvider {
    private MainDatabaseHelper mainDatabaseHelper;

    public static final Uri CATEGORIES_URI = Uri.parse("alexeysachkov.androidsimple.provider/categories");

    private static final int URI_ALL_CATEGORIES = 1;
    private static final int URI_SINGLE_CATEGORY = 2;

    private static UriMatcher uriMatcher = new UriMatcher(-1);
    static {
        uriMatcher.addURI("alexeysachkov.androidsimple.provider", "categories", URI_ALL_CATEGORIES);
        uriMatcher.addURI("alexeysachkov.androidsimple.provider", "categories/#", URI_SINGLE_CATEGORY);
    }


    public CategoriesContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (uriMatcher.match(uri)) {
            case URI_ALL_CATEGORIES:

                break;
            case URI_SINGLE_CATEGORY:
                if (TextUtils.isEmpty(selection)) {
                    selection = " WHERE " + Category.CATEGORY_ID_COLUMN + " = ? ";
                    selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                    selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
                } else {
                    selection += " AND " + Category.CATEGORY_ID_COLUMN + " = ? ";
                    selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                    selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI for querying categories: " + uri);
        }

        return mainDatabaseHelper.getWritableDatabase().delete(Category.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (uriMatcher.match(uri) == URI_ALL_CATEGORIES) {
            long ID = mainDatabaseHelper.getWritableDatabase().insert(Category.TABLE_NAME, null, values);

            return ContentUris.withAppendedId(CATEGORIES_URI, ID);
        } else {
            throw new IllegalArgumentException("Wrong URI for inserting category: " + uri);
        }
    }

    @Override
    public boolean onCreate() {
        mainDatabaseHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case URI_ALL_CATEGORIES:

                break;
            case URI_SINGLE_CATEGORY:
                if (TextUtils.isEmpty(selection)) {
                    selection = " WHERE " + Category.CATEGORY_ID_COLUMN + " = ? ";
                    selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                    selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
                } else {
                    selection += " AND " + Category.CATEGORY_ID_COLUMN + " = ? ";
                    selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                    selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI for querying categories: " + uri);
        }

        Cursor cursor = mainDatabaseHelper.getWritableDatabase().query(Category.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), CATEGORIES_URI);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        if (uriMatcher.match(uri) == URI_ALL_CATEGORIES) {
            if (TextUtils.isEmpty(selection)) {
                selection = " WHERE " + Category.CATEGORY_ID_COLUMN + " = ? ";
                selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
            } else {
                selection += " AND " + Category.CATEGORY_ID_COLUMN + " = ? ";
                selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
                selectionArgs[selectionArgs.length - 1] = uri.getLastPathSegment();
            }

            return mainDatabaseHelper.getWritableDatabase().update(Category.TABLE_NAME, values, selection, selectionArgs);
        } else {
            throw new IllegalArgumentException("Wrong URI for inserting category: " + uri);
        }
    }
}
