package com.cyberleveling.academy

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cyberleveling.core.theme.NeonCyan
import com.cyberleveling.core.theme.ShadowPurple
import com.cyberleveling.core.theme.SystemBlack
import com.cyberleveling.domain.repository.CoursePath
import kotlin.math.min

@Composable
fun AcademyScreen(
    courses: List<CoursePath> = emptyList()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SystemBlack)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "ACADEMY // COURSE PATHS",
                    style = MaterialTheme.typography.headlineMedium,
                    color = NeonCyan,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                SkillTreePanel()
            }

            items(courses) { course ->
                CourseCard(course)
            }
        }
    }
}

@Composable
private fun SkillTreePanel() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = NeonCyan.copy(alpha = 0.7f),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF101A2A),
                        Color(0xFF0E1220)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "SKILL TREE",
            style = MaterialTheme.typography.titleLarge,
            color = NeonCyan,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            listOf(
                "Linux" to NeonCyan,
                "Networking" to ShadowPurple,
                "Web" to NeonCyan,
                "Defense" to ShadowPurple
            ).forEach { (label, color) ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(74.dp)
                        .border(1.dp, color.copy(alpha = 0.8f), RoundedCornerShape(12.dp))
                        .background(color.copy(alpha = 0.12f), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelLarge,
                        color = color,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun CourseCard(course: CoursePath) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = NeonCyan.copy(alpha = 0.6f),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color(0xFF111827),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${course.xpReward} XP",
                style = MaterialTheme.typography.labelLarge,
                color = NeonCyan,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = course.category,
            style = MaterialTheme.typography.labelMedium,
            color = ShadowPurple,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        course.lessons.take(min(course.lessons.size, 3)).forEach { lesson ->
            Text(
                text = "• ${lesson.title}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.padding(bottom = 6.dp)
            )
        }
    }
}
