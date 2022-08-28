//
//  CircularImage.swift
//  iosApp
//
//  Created by Anuj Sachan on 28/08/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
struct CircleImage: View {
    var body: some View {
        Image("myImg")
            .clipShape(Circle())
            
    }
}

struct CircleImage_Previews: PreviewProvider {
    static var previews: some View {
        CircleImage()
    }
}
