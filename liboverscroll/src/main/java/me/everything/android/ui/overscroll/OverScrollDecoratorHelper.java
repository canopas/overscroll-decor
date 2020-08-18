package me.everything.android.ui.overscroll;

import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;

import me.everything.android.ui.overscroll.adapters.AbsListViewOverScrollDecorAdapter;
import me.everything.android.ui.overscroll.adapters.HorizontalScrollViewOverScrollDecorAdapter;
import me.everything.android.ui.overscroll.adapters.RecyclerViewOverScrollDecorAdapter;
import me.everything.android.ui.overscroll.adapters.ScrollViewOverScrollDecorAdapter;
import me.everything.android.ui.overscroll.adapters.StaticOverScrollDecorAdapter;
import me.everything.android.ui.overscroll.adapters.ViewPagerOverScrollDecorAdapter;

public class OverScrollDecoratorHelper {

    public static final int ORIENTATION_VERTICAL = 0;
    public static final int ORIENTATION_HORIZONTAL = 1;

    /**
     * Set up the over-scroll effect over a specified {@link RecyclerView} view.
     * <br/>Only recycler-views using <b>native</b> Android layout managers (i.e. {@link LinearLayoutManager},
     * {@link GridLayoutManager} and {@link StaggeredGridLayoutManager}) are currently supported
     * by this convenience method.
     *
     * @param recyclerView The view.
     * @param orientation  Either {@link #ORIENTATION_HORIZONTAL} or {@link #ORIENTATION_VERTICAL}.
     * @return The over-scroll effect 'decorator', enabling further effect configuration.
     */
    public static IOverScrollDecor setUpOverScroll(RecyclerView recyclerView, int orientation, boolean showBounceEffect) {
        switch (orientation) {
            case ORIENTATION_HORIZONTAL:
                return new HorizontalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(recyclerView), showBounceEffect);
            case ORIENTATION_VERTICAL:
                return new VerticalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(recyclerView), showBounceEffect);
            default:
                throw new IllegalArgumentException("orientation");
        }
    }

    public static IOverScrollDecor setUpOverScroll(RecyclerView recyclerView, int orientation) {
        return setUpOverScroll(recyclerView, orientation, true);
    }

    public static IOverScrollDecor setUpOverScroll(ListView listView) {
        return setUpOverScroll(listView, true);
    }

    public static IOverScrollDecor setUpOverScroll(GridView gridView) {
        return setUpOverScroll(gridView, true);
    }

    public static IOverScrollDecor setUpOverScroll(ScrollView scrollView) {
        return setUpOverScroll(scrollView, true);
    }

    public static IOverScrollDecor setUpOverScroll(HorizontalScrollView scrollView) {
        return setUpOverScroll(scrollView, true);
    }


    public static IOverScrollDecor setUpOverScroll(ListView listView, boolean showBounceEffect) {
        return new VerticalOverScrollBounceEffectDecorator(new AbsListViewOverScrollDecorAdapter(listView), showBounceEffect);
    }

    public static IOverScrollDecor setUpOverScroll(GridView gridView, boolean showBounceEffect) {
        return new VerticalOverScrollBounceEffectDecorator(new AbsListViewOverScrollDecorAdapter(gridView), showBounceEffect);
    }

    public static IOverScrollDecor setUpOverScroll(ScrollView scrollView, boolean showBounceEffect) {
        return new VerticalOverScrollBounceEffectDecorator(new ScrollViewOverScrollDecorAdapter(scrollView), showBounceEffect);
    }

    public static IOverScrollDecor setUpOverScroll(HorizontalScrollView scrollView, boolean showBounceEffect) {
        return new HorizontalOverScrollBounceEffectDecorator(new HorizontalScrollViewOverScrollDecorAdapter(scrollView), showBounceEffect);
    }

    /**
     * Set up the over-scroll over a generic view, assumed to always be over-scroll ready (e.g.
     * a plain text field, image view).
     *
     * @param view        The view.
     * @param orientation One of {@link #ORIENTATION_HORIZONTAL} or {@link #ORIENTATION_VERTICAL}.
     * @return The over-scroll effect 'decorator', enabling further effect configuration.
     */
    public static IOverScrollDecor setUpStaticOverScroll(View view, int orientation) {
        return setUpStaticOverScroll(view, orientation, true);
    }

    public static IOverScrollDecor setUpStaticOverScroll(View view, int orientation, boolean showBounceEffect) {
        switch (orientation) {
            case ORIENTATION_HORIZONTAL:
                return new HorizontalOverScrollBounceEffectDecorator(new StaticOverScrollDecorAdapter(view), showBounceEffect);

            case ORIENTATION_VERTICAL:
                return new VerticalOverScrollBounceEffectDecorator(new StaticOverScrollDecorAdapter(view), showBounceEffect);

            default:
                throw new IllegalArgumentException("orientation");
        }
    }

    public static IOverScrollDecor setUpOverScroll(ViewPager viewPager) {
        return setUpOverScroll(viewPager, true);
    }

    public static IOverScrollDecor setUpOverScroll(ViewPager viewPager, boolean showBounceEffect) {
        return new HorizontalOverScrollBounceEffectDecorator(new ViewPagerOverScrollDecorAdapter(viewPager), showBounceEffect);
    }
}
