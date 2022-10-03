//
//  RectangleImage.swift
//  iosApp
//
//  Created by Anuj Sachan on 28/08/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import UIKit
import Combine
import Kingfisher

struct RectangleImage: View {
    var url: String
    var body: some View {
        KFImage(URL(string: url))
            .resizable()
            .aspectRatio(CGSize(width: 4, height: 3), contentMode:.fill).animation(Animation.easeIn)
            .cornerRadius(16.0)

    }
}

struct RectangleImage_Previews: PreviewProvider {
    static var previews: some View {
        RectangleImage(url: "https://miro.medium.com/fit/c/176/176/1*JXbGEzsiOWlrcamDr3HfSA.png")
    }
}
