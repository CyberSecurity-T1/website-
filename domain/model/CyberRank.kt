package com.cyberleveling.domain.model

enum class CyberRank(
    val minLevel: Int,
    val maxLevel: Int,
    val title: String
) {
    CYBER_BEGINNER(1, 10, "Cyber Beginner"),
    SIGNAL_SCOUT(11, 30, "Signal Scout"),
    NETWORK_RANGER(31, 60, "Network Ranger"),
    PACKET_ANALYST(61, 100, "Packet Analyst"),
    FIREWALL_GUARDIAN(101, 150, "Firewall Guardian"),
    THREAT_HUNTER(151, 200, "Threat Hunter"),
    VULNERABILITY_ARCHITECT(201, 240, "Vulnerability Architect"),
    DEFENSE_LEGEND(241, 260, "Defense Legend"),
    SHADOW_SENTINEL(261, 300, "Shadow Sentinel");

    companion object {
        fun fromLevel(level: Int): CyberRank {
            return entries.firstOrNull { level in it.minLevel..it.maxLevel }
                ?: SHADOW_SENTINEL
        }

        fun titleForLevel(level: Int): String {
            return fromLevel(level).title
        }
    }
}
