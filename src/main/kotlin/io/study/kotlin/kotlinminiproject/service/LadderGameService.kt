package io.study.kotlin.kotlinminiproject.service

import io.study.kotlin.kotlinminiproject.domain.LadderCreation
import org.springframework.stereotype.Service

//rung 3
//d s j
//d -> 1, 2, 3
//|-| |
//| |-|
//|-| |

//s -> 2, 1, 2
//|-| |
//| |-|
//|-| |

//j -> 3, 2, 1
//|-| |
//| |-|
//|-| |

//rung 4
//d s j m
//d -> 1, 2, 2, 1
//|-| |-| -> 바로 옆에는 leg 생성 절대 불가
//| | | | -> 한열 에는 leg 가 비어 있을 수도 있음
//|-| | | -> leg 생성 될 수도 안될 수도 있음

//s -> 2, 1, 1, 2
//|-| |-|
//| | | |
//|-| | |

//j -> 3, 4, 4, 4
//|-| |-|
//| | | |
//|-| | |

//m -> 4, 3, 3, 3
//|-| |-|
//| | | |
//|-| | |

//1. 바로 옆은 생성 될 수 없음
//2. 한 열(rung) 에는 leg가 랜덤으로 생성
//3. 한 열(rung) 에는 leg 가 아예 없을 수도 있음

//Radder( 3Leg, 3Leg, 3Leg, 3Leg)
//Leg(left, right) -> participant - 1
//order : 4
//participant : M
//Radder.getDestination("M") -> Destinations.getName(3)
//Radder.getRoutes(Participant("M")) -> 4, 3, 3, 3

@Service
class LadderGameService {
    fun run(ladderCreation: LadderCreation) {

    }
}