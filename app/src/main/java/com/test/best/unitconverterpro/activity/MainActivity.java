package com.test.best.unitconverterpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.best.unitconverterpro.adapter.SectionAdapter;
import com.test.best.unitconverterpro.R;
import com.test.best.unitconverterpro.section.Section;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSection;
    SectionAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
    }


    private void initRecycler() {
        rvSection = findViewById(R.id.rv_section_list);

        sectionAdapter = new SectionAdapter(this, getSectionData());
        sectionAdapter.setOnSectionItemClickListener(new SectionAdapter.OnSectionItemClickListener() {
            @Override
            public void onSectionClick(Section section) {
                Intent intent = new Intent(MainActivity.this, SectionActivity.class);
                intent.putExtra("section", section.getTitle());
                startActivity(intent);
            }
        });

        rvSection.setAdapter(sectionAdapter);
        rvSection.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }

    List<Section> getSectionData() {
        List<Section> sections = new ArrayList<>();
        sections.add(new Section(Section.TEMPERATURE, R.drawable.temperature));
        sections.add(new Section(Section.LENGTH, R.drawable.length));
        sections.add(new Section(Section.MASS, R.drawable.mass));
        sections.add(new Section(Section.SPEED, R.drawable.speed));
        sections.add(new Section(Section.AREA, R.drawable.area));
        sections.add(new Section(Section.VOLUME, R.drawable.volume));
        sections.add(new Section(Section.TIME, R.drawable.time));
        sections.add(new Section(Section.DIGITAL_STORAGE, R.drawable.digital_storage));

        return sections;
    }
}
