//
//  MainVM.swift
//  iosApp
//
//  Created by Anuj Sachan on 01/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class MainVM: ObservableObject{
    let greeting = AppRepo()
    @Published var mError: String? = nil
    @Published var array: [String] = []

    func load() {
          // print("hello")

         greeting.getDog(count: 5) { result, error in
              if let result = result {
                  self.array=result.peekData() as? [String] ?? []
                 } else if let error = error {
                     self.mError = "Error: \(error)"
              }
          }
      }
    
}
